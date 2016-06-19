package ir.apk.dm.ui.user;

import ir.apk.dm.ui.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by shahin on 4/29/2016 AD.
 */
@ManagedBean(name = "navigationBean")
@SessionScoped
public class NavigationBean extends BaseBean{
	private Logger logger = LoggerFactory.getLogger(NavigationBean.class);

	@Override
	protected void init(){

	}

	public void moveToContactUs(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/contactUs.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to contactUs page : {}", ex.getMessage());
		}
	}

	public void moveToHome(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/index.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to home page : {}", ex.getMessage());
		}
	}

	public void moveToLaptop(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/laptops.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to laptop page : {}", ex.getMessage());
		}
	}

	public void moveToTablet(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/tablets.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to tablet page : {}", ex.getMessage());
		}
	}

	public void moveToMacBookPro(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/macBookPro.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to macBookPro page : {}", ex.getMessage());
		}
	}

	public void moveToIPadPro(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/iPadPro.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to iPadPro page : {}", ex.getMessage());
		}
	}

	public void moveToBlackBerryQ10(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/blackBerryQ10.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to blackBerryQ10 page : {}", ex.getMessage());
		}
	}

	public void moveToAppleLaptops(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/appleLaptops.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to appleLaptops page : {}", ex.getMessage());
		}
	}

	public void moveToAppleTablets(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/appleTablets.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to appleTablets page : {}", ex.getMessage());
		}
	}

	public void moveToBlackBerry(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/blackBerry.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to blackBerry page : {}", ex.getMessage());
		}
	}

	public void moveToCellphone(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/cellphones.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to cellphone page : {}", ex.getMessage());
		}
	}

	public void onIdle() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"No activity.", "What are you doing over there?"));
	}

	public void onActive() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Welcome Back", "Well, that's a long coffee break!"));
	}

	public void moveToSignUpPage(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/signUpPage.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to signUp page : {}", ex.getMessage());
		}
	}

	public void moveToAdmin(){
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/user/admin.jsf");
		} catch (IOException ex) {
			logger.error("User could not be redirected to admin page : {}", ex.getMessage());
		}
	}

}
