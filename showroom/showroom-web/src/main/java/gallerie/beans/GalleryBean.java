package gallerie.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;
import org.primefaces.event.RowEditEvent;

import artRoom.entities.Gallery;
import artRoom.entities.GalleryAssistant;
import artRoom.persistence.service.GalleryServiceLocal;

@ManagedBean
@ViewScoped
public class GalleryBean implements Serializable {
	private List<Gallery> galleries = new ArrayList<Gallery>();
	private Gallery gallerie = new Gallery();
	private boolean visible;
	private List<Gallery> galleryDropped;
	private Gallery selectedGallery;
	

	@EJB
	GalleryServiceLocal galleryServiceLocal;
	private GalleryAssistant assistantSelected = new GalleryAssistant();
	public void doAssignCourseToTrainer() {
		galleryServiceLocal.assignGalleryToAssistant(gallerySelected, assistantSelected);
		
		gallerySelected = new Gallery();
	}
	private Gallery gallerySelected = new Gallery();

	public List<Gallery> getGalleries() {
		return galleries;
	}

	@PostConstruct
	public void init() {
		galleries = galleryServiceLocal.findAllGallery();

	}

	public void doAdd() {
		galleryServiceLocal.addGallery(gallerie);
		gallerie = new Gallery();
		init();
		setVisible(false);

	}

	public void doDelete() {
		galleryServiceLocal.deleteGallery(gallerie);
		gallerie = new Gallery();
		init();
		setVisible(false);
	}

	public void doADDorUpdate() {
		galleryServiceLocal.addOrUpdateGallery(gallerie);
		gallerie = new Gallery();
		init();
		FacesMessage msg = new FacesMessage("Edited ");
		
		FacesContext.getCurrentInstance().addMessage("ok", msg);
		setVisible(false);
	}
	 public void onCarDrop(DragDropEvent ddEvent) {
	        Gallery gal = ((Gallery) ddEvent.getData());
	  
	        galleryDropped.add(gal);
	       
	    }
	     

	public void doCancel() {
		gallerie = new Gallery();
		setVisible(false);

	}

	public void doNew() {
		gallerie = new Gallery();
           setVisible(true);
	}

	
	public void setGalleries(List<Gallery> galleries) {
		this.galleries = galleries;
	}

	public Gallery getGallerie() {
		return gallerie;
	}

	public void setGallerie(Gallery gallerie) {
		this.gallerie = gallerie;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Gallery getSelectedGallery() {
		return selectedGallery;
	}

	public void setSelectedGallery(Gallery selectedGallery) {
		this.selectedGallery = selectedGallery;
	}

	public List<Gallery> getGalleryDropped() {
		return galleryDropped;
	}

	public void setGalleryDropped(List<Gallery> galleryDropped) {
		this.galleryDropped = galleryDropped;
	}
	 public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Gallery Edited", ((Gallery) event.getObject()).getAddress());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
}
