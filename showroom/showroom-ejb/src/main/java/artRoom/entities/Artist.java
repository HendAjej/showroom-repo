package artRoom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Artist
 *
 */
@Entity

public class Artist extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="artist")
	private List<Event> events;
	public Artist() {
		super();
	}
	public Artist(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, List<Auction> auctions, List<Complaint> complaints,
			List<Complaint> responses) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber, banned, auctions, complaints, responses);
		// TODO Auto-generated constructor stub
	}
	public Artist(byte[] picture, String firstName, String lastName, String email, String password, String role,
			String address, boolean banned, Long phoneNumber) {
		super(picture, firstName, lastName, email, password, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Artist(int idUser, String firstName, String lastName, String email, String password, String role,
			String address, boolean banned, Long phoneNumber) {
		super(idUser, firstName, lastName, email, password, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Artist(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, String role) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber, banned, role);
		// TODO Auto-generated constructor stub
	}
	public Artist(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Artist(String firstName, String lastName, String email, String role, String address, boolean banned,
			Long phoneNumber) {
		super(firstName, lastName, email, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Artist(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			boolean banned, List<Auction> auctions, List<Complaint> complaints, List<Complaint> responses) {
		super(password, address, firstName, lastName, email, phoneNumber, banned, auctions, complaints, responses);
		// TODO Auto-generated constructor stub
	}
	public Artist(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			boolean banned, String role) {
		super(password, address, firstName, lastName, email, phoneNumber, banned, role);
		// TODO Auto-generated constructor stub
	}
	public Artist(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			String positionrequest) {
		super(password, address, firstName, lastName, email, phoneNumber, positionrequest);
		// TODO Auto-generated constructor stub
	}
	public Artist(String password, String address, String firstName, String lastName, String email, Long phoneNumber) {
		super(password, address, firstName, lastName, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Artist(String firstName, String lastName, String email, String address, String password, String role,
			Long phoneNumber, boolean banned) {
		super(firstName, lastName, email, address, password, role, phoneNumber, banned);
		// TODO Auto-generated constructor stub
	}
	public Artist(String firstName, String lastName, String email, String password, String address, String role,
			Long phoneNumber) {
		super(firstName, lastName, email, password, address, role, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Artist(String role, String firstName, String lastName, String email) {
		super(role, firstName, lastName, email);
		// TODO Auto-generated constructor stub
	}
	public Artist(String firstName) {
		super(firstName);
		// TODO Auto-generated constructor stub
	}
	public Artist(List<Event> events) {
		super();
		this.events = events;
	}
	
	
   
}
