package artRoom.persistence.service;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import artRoom.entities.Gallery;

@Singleton
@LocalBean
@Startup
public class GalleryUtilities {
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	 
	public void initDb() {
		

		Gallery gallery4 = new Gallery();

		gallery4.setAddress("Tunis");

		//gallery4.setImageGallery(null);

		gallery4.setLatitude(111.3);
		gallery4.setLongitude(200.0);
		gallery4.setNameGallery("Art");
		gallery4.setStarRating(4);
		gallery4.setNbrespace(8);
		double d=gallery4.getLatitude();
		double f=gallery4.getLongitude();
		double z=d*f;
		gallery4.setSurface(z);
		
		entityManager.persist(gallery4);
		
		Gallery gallery2 = new Gallery();
		gallery2.setAddress("Paris");
		gallery2.setLatitude(10);
		gallery2.setLongitude(100);
		gallery2.setNameGallery("Picaso");
		gallery2.setStarRating(2);
		gallery2.setNbrespace(3);
		double e=gallery2.getLatitude();
		double t=gallery2.getLongitude();
		double y=e*t;
		gallery2.setSurface(y);

		gallery2.setAddress("Paris");
		entityManager.persist(gallery2);

	}

}
