package artRoom.persistence.service;

import java.util.List;

import javax.ejb.Local;

import artRoom.entities.Gallery;
import artRoom.entities.User;

@Local
public interface GalleryServiceLocal {
	void addGallery(Gallery gallery);
	
	void updateGallery(Gallery gallery);
	Gallery findGalleryById(Integer id);
	void addOrUpdateGallery(Gallery gallery);
	List<Gallery> findGalleryByName(String name);
	void deleteGallery(Gallery gallery);
	void deleteGalleryById(Integer id);
	void updateGallery1(Gallery gallery,String address,String nom,Integer nbre,Integer star);
	List<Gallery> findAllGallery();
	void assignGalleryToAssistant(Gallery gallery, User user);

}
