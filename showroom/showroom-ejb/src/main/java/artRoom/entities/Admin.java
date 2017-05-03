package artRoom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User implements Serializable {


	

	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
	
	public Admin(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, List<Auction> auctions, List<Complaint> complaints,
			List<Complaint> responses) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber, banned, auctions, complaints, responses);
		// TODO Auto-generated constructor stub
	}

	public Admin(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			boolean banned, List<Auction> auctions, List<Complaint> complaints, List<Complaint> responses) {
		super(password, address, firstName, lastName, email, phoneNumber, banned, auctions, complaints, responses);
		// TODO Auto-generated constructor stub
	}
	public Admin(String firstName, String lastName, String email, String password, String address, String role,
			Long phoneNumber) {
		super(firstName,lastName,email,password,address,role,phoneNumber);
	}

	@Override
	public String toString() {
		return "Admin [isBanned()=" + isBanned() + ", getIdUser()=" + getIdUser() + ", getPassword()=" + getPassword()
				+ ", getAuctions()=" + getAuctions() + ", getComplaints()=" + getComplaints() + ", getResponses()="
				+ getResponses() + ", getAddress()=" + getAddress() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Admin(byte[] picture, String firstName, String lastName, String email, String password, String role,
			String address, boolean banned, Long phoneNumber) {
		super(picture, firstName, lastName, email, password, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public Admin(int idUser, String firstName, String lastName, String email, String password, String role,
			String address, boolean banned, Long phoneNumber) {
		super(idUser, firstName, lastName, email, password, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, String role) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber, banned, role);
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber) {
		super(idUser, password, address, firstName, lastName, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public Admin(String firstName, String lastName, String email, String role, String address, boolean banned,
			Long phoneNumber) {
		super(firstName, lastName, email, role, address, banned, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public Admin(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			boolean banned, String role) {
		super(password, address, firstName, lastName, email, phoneNumber, banned, role);
		// TODO Auto-generated constructor stub
	}

	public Admin(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			String positionrequest) {
		super(password, address, firstName, lastName, email, phoneNumber, positionrequest);
		// TODO Auto-generated constructor stub
	}

	public Admin(String password, String address, String firstName, String lastName, String email, Long phoneNumber) {
		super(password, address, firstName, lastName, email, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public Admin(String firstName, String lastName, String email, String address, String password, String role,
			Long phoneNumber, boolean banned) {
		super(firstName, lastName, email, address, password, role, phoneNumber, banned);
		// TODO Auto-generated constructor stub
	}

	public Admin(String role, String firstName, String lastName, String email) {
		super(role, firstName, lastName, email);
		// TODO Auto-generated constructor stub
	}

	public Admin(String firstName) {
		super(firstName);
		// TODO Auto-generated constructor stub
	}
	

	

}
