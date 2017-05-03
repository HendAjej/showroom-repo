package showroom.complaint;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import showroom.persistence.service.SendMailLocal;

@ManagedBean
@ViewScoped
public class contactBean {

	private String username;
	private String password;
	private String subject;
	private String message;

	@EJB
	SendMailLocal sendMailLocal;

	public String send() {
		sendMailLocal.envoyer(username, password, subject, message);
		return "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
