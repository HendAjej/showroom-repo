package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import artRoom.entities.User;
import artRoom.entities.Admin;
import artRoom.entities.Artist;
import artRoom.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	private UserServiceLocal subscriptionServiceLocal;
	private Boolean loggedInAsAgent = false;
	private User user = new User();
	/*public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = subscriptionServiceLocal.authentificate(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Admin) {
				navigateTo = "/panel/admin/user/list?faces-redirect=true";
			} else if (userLoggedIn instanceof User) {
				navigateTo = "/panel/profile/myprofile?faces-redirect=true";
		}} else {
			System.err.println("not");
		}
		return navigateTo;
		}*/
	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = subscriptionServiceLocal.authentificate(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Admin) {
				return "/panel/admin/user/list?faces-redirect=true";
			} else {
				loggedInAsAgent = true;
				navigateTo = "/panel/profile/myprofile?faces-redirect=true";
			}
		} else {
			System.err.println("not");
		}
		return navigateTo;
	}
	/*public String doLogin() {
		String navigateTo = "";
	    User userLoggedIn = subscriptionServiceLocal.authentificate(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			                      user = userLoggedIn;
		                          if (userLoggedIn instanceof Admin) {
				                  System.out.println("admin");
				                  loggedInAsAgent = true;
                                  navigateTo = "/panel/admin/user/list?faces-redirect=true";
			                      } else {
				                  loggedInAsAgent = true;
				                  navigateTo = "/panel/profile/myprofile?faces-redirect=true";} 
		                          } 
	   else  {
			   System.err.println("not");
		     }
		return navigateTo;
	}*/
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsAgent() {
		return loggedInAsAgent;
	}

	public void setLoggedInAsAgent(Boolean loggedInAsAgent) {
		this.loggedInAsAgent = loggedInAsAgent;
	}
}
