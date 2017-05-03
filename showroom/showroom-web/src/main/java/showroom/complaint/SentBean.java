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
import showroom.persistence.service.ComplaintServicesLocal;

@ManagedBean
@ViewScoped
public class SentBean implements Serializable {

	@EJB
	ComplaintServicesLocal  complaintServicesLocal;
	
	private List<Complaint> complaints= new ArrayList<Complaint>();
	private Complaint complaint=new Complaint();
	private static final long serialVersionUID = 1L;
	
	
	
	@PostConstruct
	public void listComplaint(){
		complaints= complaintServicesLocal.findAllYourComplaints(3);
	}
	public void doDelete(){
		complaintServicesLocal.deleteComplaint(complaint);
		complaint=new Complaint();
		listComplaint();
		
	}
	public void doSend() {
		//int id=userLogged.getIdUser();
		ComplaintId cmpID = new ComplaintId(3, 2);
		complaint.setComplaintId(cmpID);
		complaintServicesLocal.addComplaint2(complaint);
		User receiver = complaintServicesLocal.findReceiverById(2);
		String text = "vous avez reçu une reclamation check your inbox please";
		Notification notification = new Notification(text, receiver);
		notification.setSeen(false);
		//notificationServicesLocal.addNote(notification);
		complaint = new Complaint();
		listComplaint();
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

	 
	
	
}
