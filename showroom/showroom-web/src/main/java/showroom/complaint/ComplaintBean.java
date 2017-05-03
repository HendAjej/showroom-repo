package showroom.complaint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import artRoom.entities.Complaint;
import artRoom.entities.ComplaintId;
import artRoom.entities.Notification;
import artRoom.entities.User;
import showroom.jsf.NotificationsLocal;
import showroom.persistence.service.ComplaintServicesLocal;

@ManagedBean
@ViewScoped
public class ComplaintBean implements Serializable {

	@EJB
	ComplaintServicesLocal complaintServicesLocal;
	@EJB
	NotificationsLocal notificationServicesLocal;

	private List<Complaint> complaints = new ArrayList<Complaint>();
	private Complaint complaint = new Complaint();
	private String recherche;
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		complaints = complaintServicesLocal.findAllComplaints(1);
	}

	public void doSend() {
		ComplaintId cmpID = new ComplaintId(1, 2);
		complaint.setComplaintId(cmpID);
		complaintServicesLocal.addComplaint2(complaint);
		User receiver = complaintServicesLocal.findReceiverById(2);
		String text = "vous avez reçu une reclamation de la part de " + receiver.getFirstName() + " "
				+ receiver.getLastName() + "/n check your inbox please";
		Notification notification = new Notification(text, receiver);
		notification.setSeen(false);
		notificationServicesLocal.addNote(notification);
		complaint = new Complaint();
		init();
	}

	public void doDelete() {
		complaintServicesLocal.deleteComplaint(complaint);
		complaint = new Complaint();
		init();

	}

	public void ajaxEvent() {

		complaints = complaintServicesLocal.Search(recherche, 1);
		System.out.println(recherche);

	}

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

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

}
