package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import artRoom.entities.User;
import artRoom.entities.Admin;
import artRoom.entities.Artist;
import artRoom.entities.GalleryAssistant;


import artRoom.services.UserServiceRemote;
import artRoom.services.UserServiceLocal;

@ManagedBean(name = "authentification")
@SessionScoped

public class Authentification implements Serializable {

	private static final long serialVersionUID = 9180273794028394011L;

	@EJB
/*	private UserServiceLocal service;
	private User user;*/
	private UserServiceLocal subscriptionServiceLocal;
	private Boolean loggedInAsAgent = false;
	private User user = new User();
	@PostConstruct
	public void init() {
		user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public String Login() {
		user = service.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

	  if (user.getRole().equals("Admin") ) {
			return "/panel/admin/user/list?faces-redirect=true";
		} else if (user.getRole().equals("Artist")) {
			return "/Artist/home?faces-redirect=true";
		}else if (user.getRole().equals("GalleryOwner")) {
			return "/panel/profile/myprofile?faces-redirect=true";
		} else if (user.getRole().equals("Client")) {
			return "/public/welcome?faces-redirect=true";
		} else {
			FacesMessage msg = new FacesMessage("Incorrect email or password");
			FacesContext.getCurrentInstance().addMessage("err", msg);
			return null;
		}
	}
*/
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = subscriptionServiceLocal.authentificate(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Admin) {
				return "/panel/admin/user/list?faces-redirect=true";
			} else if (userLoggedIn instanceof Artist){
				setLoggedInAsAgent(true);
				navigateTo = "/Profile/myprofile?faces-redirect=true";
			}else if (userLoggedIn instanceof GalleryAssistant){
				setLoggedInAsAgent(true);
				navigateTo = "/Profile/myprofile?faces-redirect=true";
			}else if (userLoggedIn instanceof User){
				setLoggedInAsAgent(true);
				navigateTo = "/Profile/myprofile?faces-redirect=true";
			}
		} else {
			System.err.println("not");
		}
		return navigateTo;
	}
/*	public UserServiceLocal getService() {
		return service;
	}

	public void setService(UserServiceLocal service) {
		this.service = service;
	}
*/
	public Boolean getLoggedInAsAgent() {
		return loggedInAsAgent;
	}

	public void setLoggedInAsAgent(Boolean loggedInAsAgent) {
		this.loggedInAsAgent = loggedInAsAgent;
	}

}
