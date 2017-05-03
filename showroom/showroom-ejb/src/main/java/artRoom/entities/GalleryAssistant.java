package artRoom.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GalleryAssistant
 *
 */
@Entity

public class GalleryAssistant extends User implements Serializable {

	
	private String position;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Gallery gallery;

	public GalleryAssistant() {
		super();
	}   
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	public GalleryAssistant(byte[] picture, String firstName, String lastName, String email, String password,
			String role, String address, boolean banned, Long phoneNumber) {
		super(picture, firstName, lastName, email, password, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(int idUser, String firstName, String lastName, String email, String password, String role,
			String address, boolean banned, Long phoneNumber) {
		super(idUser, firstName, lastName, email, password, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(Integer idUser, String password, String address, String firstName, String lastName,
			String email, Long phoneNumber, boolean banned, List<Auction> auctions, List<Complaint> complaints,
			List<Complaint> responses) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber, banned, auctions, complaints, responses);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(Integer idUser, String password, String address, String firstName, String lastName,
			String email, Long phoneNumber, boolean banned, String role) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber, banned, role);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(Integer idUser, String password, String address, String firstName, String lastName,
			String email, Long phoneNumber) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String firstName, String lastName, String email, String role, String address,
			boolean banned, Long phoneNumber) {
		super(firstName, lastName, email, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, List<Auction> auctions, List<Complaint> complaints,
			List<Complaint> responses) {
		super(password, address, firstName, lastName, email, phoneNumber, banned, auctions, complaints, responses);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, String role) {
		super(password, address, firstName, lastName, email, phoneNumber, banned, role);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, String positionrequest) {
		super(password, address, firstName, lastName, email, phoneNumber, positionrequest);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String password, String address, String firstName, String lastName, String email,
			Long phoneNumber) {
		super(password, address, firstName, lastName, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String firstName, String lastName, String email, String address, String password,
			String role, Long phoneNumber, boolean banned) {
		super(firstName, lastName, email, address, password, role, phoneNumber, banned);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String firstName, String lastName, String email, String password, String address,
			String role, Long phoneNumber) {
		super(firstName, lastName, email, password, address, role, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String role, String firstName, String lastName, String email) {
		super(role, firstName, lastName, email);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String firstName) {
		super(firstName);
		// TODO Auto-generated constructor stub
	}
	public GalleryAssistant(String position, Gallery gallery) {
		super();
		this.position = position;
		this.gallery = gallery;
	}
   
}
