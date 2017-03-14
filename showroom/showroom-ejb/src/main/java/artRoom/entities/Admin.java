package artRoom.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

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

	@Override
	public String toString() {
		return "Admin [isBanned()=" + isBanned() + ", getIdUser()=" + getIdUser() + ", getPassword()=" + getPassword()
				+ ", getAuctions()=" + getAuctions() + ", getComplaints()=" + getComplaints() + ", getResponses()="
				+ getResponses() + ", getAddress()=" + getAddress() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

	

}
