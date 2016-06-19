package ir.apk.dm.ui.user;

import ir.apk.dm.core.CoreServer;
import ir.apk.dm.core.model.AccountInfo;
import ir.apk.dm.ui.BaseBean;
import ir.apk.dm.ui.util.PasswordEncryptionService;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BaseBean {
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;
	private Logger logger = LoggerFactory.getLogger(LoginBean.class);
	private String                    userName;
	private String                    attemptedPassword;
	private boolean                   isLoggedIn;
	private PasswordEncryptionService service;
	private String                    welcome;
	private AccountInfo               accountInfo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAttemptedPassword() {
		return attemptedPassword;
	}

	public void setAttemptedPassword(String attemptedPassword) {
		this.attemptedPassword = attemptedPassword;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		isLoggedIn = loggedIn;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	@Override
	protected void init() {
		isLoggedIn = false;
		service = new PasswordEncryptionService();
	}

	public void logOut() {
		isLoggedIn = false;
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "test", "test");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		//showMessage("", getMessage("YES"), FacesMessage.SEVERITY_INFO);
		navigationBean.moveToHome();
	}

	public void login() {
		accountInfo = CoreServer.INSTANCE.getAccountInfo(userName);
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		if (userName != null && accountInfo != null) {
			if (service.authenticate(attemptedPassword, accountInfo.getPassword(), accountInfo.getSalt())) {
				if (!accountInfo.isAdmin()) {
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userName);
					isLoggedIn = true;
					welcome = "Welcome dear " + userName;
				} else {
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userName);
					isLoggedIn = true;
					welcome = "Welcome " + userName;
					navigationBean.moveToAdmin();
				}
			}
		} else {
			isLoggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", isLoggedIn);
	}

}
