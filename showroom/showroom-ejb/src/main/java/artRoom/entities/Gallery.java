package artRoom.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Gallery
 *
 */
@Entity

public class Gallery implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id

	private Integer idGallery;
	private String address;
	private Integer starRating;
	// @Lob
	// private byte[] imageGallery;
	// @NotNull
	// @Size(min=4,max=10)
	private String nameGallery;
	private double latitude;
	private double longitude;
	private double surface = latitude * longitude;
	private Integer nbrespace;
	@ManyToOne(cascade = CascadeType.MERGE)
	private User assistant;
	
	@ManyToMany
	private List<Artwork> artworks;

	public User getAssistant() {
		return assistant;
	}

	public void setAssistant(User assistant) {
		this.assistant = assistant;
	}

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "gallery")
	private List<GalleryAssistant> galleryAssistants;

	@OneToMany(mappedBy = "galleryEvent")
	private List<Event> events;

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

	public Integer getStarRating() {
		return starRating;
	}

	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}

	public Gallery(String nameGallery, User assistant) {
		super();
		this.nameGallery = nameGallery;
		this.assistant = assistant;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double d) {
		this.latitude = d;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getNameGallery() {
		return nameGallery;
	}

	public void setNameGallery(String nameGallery) {
		this.nameGallery = nameGallery;
	}

	/*
	 * public Gallery(String address, Integer starRating, byte[] imageGallery,
	 * String nameGallery, double latitude, double longitude) { super();
	 * this.address = address; this.starRating = starRating; this.imageGallery =
	 * imageGallery; this.nameGallery = nameGallery; this.latitude = latitude;
	 * this.longitude = longitude; }
	 * 
	 * public Gallery(Integer idGallery, String address, Integer starRating,
	 * byte[] imageGallery, String nameGallery, double latitude, double
	 * longitude) { super(); this.idGallery = idGallery; this.address = address;
	 * this.starRating = starRating; this.imageGallery = imageGallery;
	 * this.nameGallery = nameGallery; this.latitude = latitude; this.longitude
	 * = longitude; } public byte[] getImageGallery() { return imageGallery; }
	 * public void setImageGallery(byte[] imageGallery) { this.imageGallery =
	 * imageGallery; }
	 */
	public Gallery(String address, String nameGallery) {
		super();
		this.address = address;
		this.nameGallery = nameGallery;
	}

	public double getSurface() {
		double a = getLatitude() * getLongitude();
		return a;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public Integer getNbrespace() {
		return nbrespace;
	}

	public void setNbrespace(Integer nbrespace) {
		this.nbrespace = nbrespace;
	}

	public Gallery(String address, Integer starRating, String nameGallery, double latitude, double longitude,
			Integer nbrespace) {
		super();
		this.address = address;
		this.starRating = starRating;
		this.nameGallery = nameGallery;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nbrespace = nbrespace;
	}

	public Gallery(Integer idGallery, String address, Integer starRating, String nameGallery, double latitude,
			double longitude, double surface, Integer nbrespace, List<GalleryAssistant> galleryAssistants) {
		super();
		this.idGallery = idGallery;
		this.address = address;
		this.starRating = starRating;
		this.nameGallery = nameGallery;
		this.latitude = latitude;
		this.longitude = longitude;
		this.surface = surface;
		this.nbrespace = nbrespace;
		this.galleryAssistants = galleryAssistants;
	}

	public Gallery(Integer idGallery, String address, Integer starRating, String nameGallery, double latitude,
			double longitude, double surface, Integer nbrespace, User assistant) {
		super();
		this.idGallery = idGallery;
		this.address = address;
		this.starRating = starRating;
		this.nameGallery = nameGallery;
		this.latitude = latitude;
		this.longitude = longitude;
		this.surface = surface;
		this.nbrespace = nbrespace;
		this.assistant = assistant;
	}

	public List<GalleryAssistant> getGalleryAssistants() {
		return galleryAssistants;
	}

	public void setGalleryAssistants(List<GalleryAssistant> galleryAssistants) {
		this.galleryAssistants = galleryAssistants;
	}

	public Gallery(String address, Integer starRating, String nameGallery, double latitude, double longitude,
			double surface, Integer nbrespace) {
		super();
		this.address = address;
		this.starRating = starRating;
		this.nameGallery = nameGallery;
		this.latitude = latitude;
		this.longitude = longitude;
		this.surface = surface;
		this.nbrespace = nbrespace;
	}

	/*
	 * public Gallery(String address, Integer starRating, byte[] imageGallery,
	 * String nameGallery, double latitude, double longitude, double surface,
	 * Integer nbrespace) { super(); this.address = address; this.starRating =
	 * starRating; this.imageGallery = imageGallery; this.nameGallery =
	 * nameGallery; this.latitude = latitude; this.longitude = longitude;
	 * this.surface = surface; this.nbrespace = nbrespace; }
	 */
	public Gallery(String address, String nameGallery, double latitude, double longitude) {
		super();
		this.address = address;
		this.nameGallery = nameGallery;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Gallery(Integer idGallery, String address, Integer starRating, String nameGallery, double latitude,
			double longitude, double surface, Integer nbrespace) {
		super();
		this.idGallery = idGallery;
		this.address = address;
		this.starRating = starRating;
		this.nameGallery = nameGallery;
		this.latitude = latitude;
		this.longitude = longitude;
		this.surface = surface;
		this.nbrespace = nbrespace;
	}

	public Gallery(String address, Integer starRating, String nameGallery, Integer nbrespace) {
		super();
		this.address = address;
		this.starRating = starRating;
		this.nameGallery = nameGallery;
		this.nbrespace = nbrespace;
	}

	@Override
	public String toString() {
		return "Gallery [idGallery=" + idGallery + ", address=" + address + ", starRating=" + starRating
				+ ", nameGallery=" + nameGallery + ", latitude=" + latitude + ", longitude=" + longitude + ", surface="
				+ surface + ", nbrespace=" + nbrespace + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((idGallery == null) ? 0 : idGallery.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nameGallery == null) ? 0 : nameGallery.hashCode());
		result = prime * result + ((nbrespace == null) ? 0 : nbrespace.hashCode());
		result = prime * result + ((starRating == null) ? 0 : starRating.hashCode());
		temp = Double.doubleToLongBits(surface);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gallery other = (Gallery) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (idGallery == null) {
			if (other.idGallery != null)
				return false;
		} else if (!idGallery.equals(other.idGallery))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (nameGallery == null) {
			if (other.nameGallery != null)
				return false;
		} else if (!nameGallery.equals(other.nameGallery))
			return false;
		if (nbrespace == null) {
			if (other.nbrespace != null)
				return false;
		} else if (!nbrespace.equals(other.nbrespace))
			return false;
		if (starRating == null) {
			if (other.starRating != null)
				return false;
		} else if (!starRating.equals(other.starRating))
			return false;
		if (Double.doubleToLongBits(surface) != Double.doubleToLongBits(other.surface))
			return false;
		return true;
	}
	@OneToMany(mappedBy="galleryart")
	public List<Artwork> getArtworks() {
		return artworks;
	}
	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}



}
