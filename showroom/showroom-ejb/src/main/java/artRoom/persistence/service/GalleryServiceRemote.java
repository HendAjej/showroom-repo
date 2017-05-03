package artRoom.persistence.service;

import java.util.List;

import javax.ejb.Remote;

import artRoom.entities.Gallery;

@Remote
public interface GalleryServiceRemote {
	

	void addGallery(Gallery gallery);

	Gallery findGalleryById(Integer id);

	List<Gallery> findGalleryByName(String name);
	void deleteGalleryById(Integer id);

	void deleteGallery(Gallery gallery);

	void updateGallery(Gallery gallery);
	void updateGallery1(Gallery gallery,String address,String nom,Integer nbre,Integer star);
	List<Gallery> findAllGallery();
}
