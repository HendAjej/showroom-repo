package artRoom.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.websocket.OnMessage;

/**
 * Entity implementation class for Entity: Gallery
 *
 */
@Entity

public class Gallery implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	
	private Integer idGallery;
	private String address;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="gallery")
	private List<GalleryAssistant> galleryAssistants;
	
	@OneToMany(mappedBy="galleryEvent")
	private List<Event> events;
	
	@ManyToMany
	private List<Artwork> artworks;
	
	

	public Gallery() {
		super();
	}   
	public Integer getIdGallery() {
		return this.idGallery;
	}

	public void setIdGallery(Integer idGallery) {
		this.idGallery = idGallery;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Gallery(String address) {
		super();
		this.address = address;
	}
	
	@OneToMany(mappedBy="galleryart")
	public List<Artwork> getArtworks() {
		return artworks;
	}
	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}
	
	
	
   
}
