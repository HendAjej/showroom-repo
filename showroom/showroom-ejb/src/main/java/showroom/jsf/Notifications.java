package showroom.jsf;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import artRoom.entities.Notification;
import artRoom.entities.User;


/**
 * Session Bean implementation class Notifications
 */
@Stateful
@LocalBean
public class Notifications implements NotificationsRemote, NotificationsLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public Notifications() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Notification> getNotifications(User u) {
		List<Notification> list = entityManager.createQuery("select d from Notification d where d.user.idUser  = ?1 ORDER BY d.date desc GROUP BY d.seen",Notification.class).setParameter(1, u.getIdUser()).getResultList();
		System.out.println("idUser"+list+u.getIdUser());
		return list;
	}
	@Override
	public void addNote(Notification note) {
		entityManager.persist(note);
	}

}
