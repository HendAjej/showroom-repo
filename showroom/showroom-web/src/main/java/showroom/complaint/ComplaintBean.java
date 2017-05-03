package showroom.complaint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import artRoom.entities.Complaint;
import artRoom.entities.ComplaintId;
import artRoom.entities.Notification;
import artRoom.entities.User;
import beans.Authentification;
import beans.Identity;
import showroom.jsf.NotificationsLocal;
import showroom.persistence.service.ComplaintServicesLocal;

@ManagedBean
@ViewScoped
public class ComplaintBean implements Serializable {

	@EJB
	ComplaintServicesLocal complaintServicesLocal;
	@EJB
	NotificationsLocal notificationServicesLocal;
	
	/*@ManagedProperty(value ="#{authentification}")
	private Authentification auth;*/

	private List<Complaint> complaints = new ArrayList<Complaint>();
	private Complaint complaint = new Complaint();
	//private String recherche;
	//private User userLogged=auth.getUser();
	private static final long serialVersionUID = 1L;
	
	

	@PostConstruct
	public void init() {
		complaints = complaintServicesLocal.findAllComplaints(3);
		
	}


	public void doDelete() {
		complaintServicesLocal.deleteComplaint(complaint);
		complaint = new Complaint();
		init();

	}

	/*public void ajaxEvent() {

		complaints = complaintServicesLocal.Search(recherche, 1);
		System.out.println(recherche);

	}*/

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	/*public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
*/


}
