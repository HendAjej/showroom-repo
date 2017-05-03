package artRoom.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import artRoom.entities.Gallery;
import artRoom.entities.User;

/**
 * Session Bean implementation class GalleryService
 */
@Stateless

public class GalleryService implements GalleryServiceRemote, GalleryServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public GalleryService() {
		// TODO Auto-generated constructor stub
	}

	@Override

	public void addGallery(Gallery gallery) {
		entityManager.persist(gallery);

	}

	@Override
	public Gallery findGalleryById(Integer id) {

		return entityManager.find(Gallery.class, id);
	}

	@Override
	public void deleteGalleryById(Integer id) {
		entityManager.remove(findGalleryById(id));

	}

	@Override
	public void deleteGallery(Gallery gallery) {
		entityManager.remove(entityManager.merge(gallery));

	}

	@Override
	public void updateGallery(Gallery gallery) {
		entityManager.merge(gallery);

	}

	@Override
	public List<Gallery> findAllGallery() {
		return entityManager.createQuery("select g from Gallery g ", Gallery.class).getResultList();
	}

	@Override
	public void updateGallery1(Gallery gallery, String address, String nom, Integer nbre, Integer star) {
		entityManager.merge(gallery);

	}

	@Override
	public List<Gallery> findGalleryByName(String name) {
		return entityManager.createQuery("select e from Gallery e where e.nameGallery LIKE name1")
				.setParameter("name1", name).getResultList();
		// Query query = entityManager.createQuery("select e from Gallery e
		// where e.nameGallery=:name");
		// query.setParameter("name", name);
	}

	@Override
	public void addOrUpdateGallery(Gallery gallery) {
		entityManager.merge(gallery);

	}

	@Override
	public void assignGalleryToAssistant(Gallery gallery, User user) {

		gallery.setAssistant(user);
		entityManager.merge(gallery);

	}

}
