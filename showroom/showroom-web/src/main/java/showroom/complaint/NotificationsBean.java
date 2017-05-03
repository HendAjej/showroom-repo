package showroom.complaint;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import artRoom.entities.Notification;
import showroom.jsf.NotificationsLocal;
import showroom.persistence.service.ComplaintServicesLocal;



@ManagedBean
@SessionScoped
public class NotificationsBean {
//
	
	@EJB
	ComplaintServicesLocal  complaintServicesLocal;
	
	@EJB
	private NotificationsLocal notificationsLocal;

	private List<Notification> notifications= new ArrayList<>();

	public void getallNotifications() {
		notifications = notificationsLocal.getNotifications(complaintServicesLocal.findComplainerById(1));
}
	public List<Notification> getNotifications() {
			return notifications ;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	
	
	
}
