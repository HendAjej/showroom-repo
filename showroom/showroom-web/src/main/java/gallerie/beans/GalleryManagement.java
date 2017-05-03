package gallerie.beans;

import javax.ejb.EJB;

import artRoom.entities.Gallery;
import artRoom.entities.GalleryAssistant;
import artRoom.persistence.service.GalleryServiceLocal;

public class GalleryManagement {
	@EJB
	private GalleryServiceLocal galleryServiceLocal;
	private Gallery gallerySelected = new Gallery();
	private GalleryAssistant assistantSelected = new GalleryAssistant();
	public void doAssignCourseToTrainer() {
		galleryServiceLocal.assignGalleryToAssistant(gallerySelected, assistantSelected);
		
		gallerySelected = new Gallery();
	}
}
