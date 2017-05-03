package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import artRoom.services.*;
import beans.UserBean;

@ManagedBean
@RequestScoped

public class RegistrationValidator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private UserServiceLocal UserService;
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void usernameValidation(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String loginToValidate = (String) value;
		if (loginToValidate == null || loginToValidate.trim().isEmpty()) {
			return;
		}
		if (UserService.findByUsername(loginToValidate) != null) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "login already in use!"));
		}
	}

	public void mailValidation(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String mail = (String) value;
		if (mail == null || mail.trim().isEmpty()) {
			return;
		}
		if (UserService.findByEmail(mail) != null) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Email already in use!"));
		}
		if (!UserService.verifyMail(mail)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Bad email "));
		}
	}

	public void firstnameValidation(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String firstname = (String) value;
		for (int i = 0; i < firstname.trim().length(); i++) {
			if ((firstname.trim().toUpperCase().charAt(i) > 90) || (firstname.trim().toUpperCase().charAt(i) < 65)) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"First Name must Contains only characters"));
			}
		}
	}

	public void lastnameValidation(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String lastname = (String) value;
		for (int i = 0; i < lastname.trim().length(); i++) {
			if ((lastname.trim().toUpperCase().charAt(i) > 90) || (lastname.trim().toUpperCase().charAt(i) < 65)) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Last Name must Contains only characters"));
			}
		}
	}

	
	public void passwordValidation(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		String password = (String) value;
		String verification = (String) component.getAttributes().get("confirm");
		if (!password.equals(verification)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"Password Doesn't Match"));
		}

	}
	

}
