package beans;

import javax.faces.bean.ManagedBean;

import beans.Utils;

@ManagedBean
public class ProfileBean {
	
	
	public String dorenderMyProfle()
	{
		return "/Profile/myprofile?faces-redirect=true";
	}
	public String dorenderLogOut()
	{
		Utils.getSession().setAttribute("email", null);
		return "/login?faces-redirect=true";
	}
	public String dorenderHome()
	{
		return "/public/welcome?faces-redirect=true";
	}
	public String doContact()
	{
		return "/public/contact?faces-redirect=true";
	}

}
