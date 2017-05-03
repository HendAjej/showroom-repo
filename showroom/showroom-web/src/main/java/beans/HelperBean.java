package beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import artRoom.entities.User;
import artRoom.entities.Admin;
import artRoom.entities.Artist;

import artRoom.services.UserServiceRemote;
import artRoom.services.UserServiceLocal;

@ManagedBean
@ApplicationScoped
public class HelperBean implements Serializable {

	@EJB
	private UserServiceLocal userManagment;

	private byte[] defaultPicture;

	public HelperBean() {
	}

	@PostConstruct
	public void init() {

		InputStream is = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("/resources/img/PasDePhotoDeProfil.png");

		
	}

	public User findUserByName(String name) {
		return userManagment.findByUsername(name);
	}

	public byte[] getDefaultPicture() {
		return defaultPicture;
	}

	public void setDefaultPicture(byte[] defaultPicture) {
		this.defaultPicture = defaultPicture;
	}

}
