package artRoom.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import artRoom.entities.Artwork;
@Entity
public class Discount implements Serializable {

	private static final long serialVersionUID = -5311928979203636240L;
	private int id;
	private int discountvalue;
	private Date start_date;
	private Date end_date;
	@ManyToMany
	private List<Artwork> artworks;
	//@ManyToMany
	//private List<Discount> discounts;


	public Discount() {
		super();
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	public Discount(int discountvalue, Date start_date, Date end_date) {
		super();
		this.discountvalue = discountvalue;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Discount(int id, int discountvalue, Date start_date, Date end_date) {
		super();
		this.id = id;
		this.discountvalue = discountvalue;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Discount(int discountvalue, Date start_date, Date end_date, List<Artwork> artworks) {
		super();
		this.discountvalue = discountvalue;
		this.start_date = start_date;
		this.end_date = end_date;
		this.artworks = artworks;
	}

	public Discount(int id, int discountvalue, Date start_date, Date end_date, List<Artwork> artworks) {
		super();
		this.id = id;
		this.discountvalue = discountvalue;
		this.start_date = start_date;
		this.end_date = end_date;
		this.artworks = artworks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getStart_date() {
		return start_date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEnd_date() {
		return end_date;
	}

	@ManyToMany
	@JoinTable(name = "Discount_Item", joinColumns = @JoinColumn(name = "idDiscount") , inverseJoinColumns = @JoinColumn(name = "idArtwork") )
	public List<Artwork> getArtworks() {
		return artworks;
	}

	public int getDiscountvalue() {
		return discountvalue;
	}

	public void setDiscountvalue(int discountvalue) {
		this.discountvalue = discountvalue;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setItems(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", discountvalue=" + discountvalue + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discountvalue;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + id;
		result = prime * result + ((artworks == null) ? 0 : artworks.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
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
		Discount other = (Discount) obj;
		if (discountvalue != other.discountvalue)
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (id != other.id)
			return false;
		if (artworks == null) {
			if (other.artworks != null)
				return false;
		} else if (!artworks.equals(other.artworks))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}

}
