package showroom.jsf;

import java.util.List;

import javax.ejb.Local;

import artRoom.entities.Notification;
import artRoom.entities.User;


@Local
public interface NotificationsLocal {

	public List<Notification> getNotifications(User u);

	void addNote(Notification note);
}
