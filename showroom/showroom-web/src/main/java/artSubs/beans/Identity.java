package artSubs.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import artRoom.entities.Admin;
import artRoom.entities.GalleryAssistant;
import artRoom.entities.User;
import artRoom.subscription.SubscriptionServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
@EJB
private SubscriptionServiceLocal subscriptionServiceLocal;
private Boolean loggedInAsAdmin = false;
private User user = new User();
private boolean isLogged = false;




public String doLogin() {
	String navigateTo = "";
	User userLoggedIn = subscriptionServiceLocal.login(user.getFirstName(), user.getPassword());
	if (userLoggedIn != null) {
		isLogged = true;
		user = userLoggedIn;
		if (userLoggedIn instanceof Admin) {
			
			System.out.println("heeend");
			
			navigateTo = "/gestionGallerie/manage?faces-redirect=true";
			loggedInAsAdmin = true;
		System.out.println("heeend");
		}
		else if (userLoggedIn instanceof GalleryAssistant) {
			System.out.println("Daly");
			
		}
	} else {
		System.err.println("not");
	}
	return navigateTo;
}







public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public boolean isLogged() {
	return isLogged;
}
public void setLogged(boolean isLogged) {
	this.isLogged = isLogged;
}
public Boolean getLoggedInAsAdmin() {
	return loggedInAsAdmin;
}
public void setLoggedInAsAdmin(Boolean loggedInAsAdmin) {
	this.loggedInAsAdmin = loggedInAsAdmin;
}

}
