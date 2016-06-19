package ir.apk.dm.ui.user;

import ir.apk.dm.core.CoreServer;
import ir.apk.dm.core.model.AccountInfo;
import ir.apk.dm.ui.BaseBean;
import ir.apk.dm.ui.util.PasswordEncryptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by shahin on 4/19/2016 AD.
 */
@ManagedBean(name = "accountBean")
@ViewScoped
public class AccountBean extends BaseBean {
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean      loginBean;
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;
	private Logger logger = LoggerFactory.getLogger(AccountBean.class);
	private String                    userName;
	private String                    password;
	private String                    firstName;
	private String                    lastName;
	private String                    tel;
	private String                    address;
	private boolean                   isAdmin;
	private PasswordEncryptionService service;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	@Override
	protected void init() {
		isAdmin = true;
		service = new PasswordEncryptionService();
		Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestCookieMap();
	}

	public void signUp() {
		byte[] salt = service.generateSalt();
		byte[] encryptedPassword = service.getEncryptedPassword(password, salt);
		AccountInfo accountInfo = new AccountInfo(firstName, lastName, tel, address, 0L, userName, encryptedPassword, salt, isAdmin);
		if (CoreServer.INSTANCE.addNewAccount(accountInfo)) {
			loginBean.setLoggedIn(true);
			loginBean.setWelcome("Welcome dear " + accountInfo.getUserName());
			if (!isAdmin)
				navigationBean.moveToHome();
			else
				navigationBean.moveToAdmin();
			showMessage("", "New account added successfully", FacesMessage.SEVERITY_INFO);
		} else {
			showMessage("", "Couldn't add new account", FacesMessage.SEVERITY_WARN);
		}
	}
}