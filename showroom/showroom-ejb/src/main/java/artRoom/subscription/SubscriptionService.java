package artRoom.subscription;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import artRoom.entities.GalleryAssistant;
import artRoom.entities.User;

@Stateless
public class SubscriptionService implements SubscriptionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User login(String firstName, String password) {
		User user = null;
		try {
			user = (User) entityManager.createQuery("select u from User u where u.firstName=:param1 and u.password=:param2")
					.setParameter("param1", firstName).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;
	}

	@Override
	public GalleryAssistant findAssistantByName(String firstName) {
		return entityManager.createQuery("SELECT c FROM User c WHERE c.firstName=:p", GalleryAssistant.class)
				.setParameter("p", firstName).getSingleResult();
	}
}
