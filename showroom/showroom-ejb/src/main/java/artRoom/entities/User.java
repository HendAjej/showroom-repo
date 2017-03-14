package artRoom.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;
	private String password;
	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
    private boolean banned;
    private String role;
    private String positionrequest;
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="owner")
	private List<Auction> auctions;
	
	@OneToMany(mappedBy="complainer")
	private List<Complaint> complaints;
	
	@OneToMany(mappedBy="receiver")
	private List<Complaint> responses;

	public User() {
		super();
	}  
	
	public User(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, String role) {
		super();
		this.idUser = idUser;
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.banned = banned;
		this.role = role;
	}
	public User(String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, String role) {
		super();
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.banned = banned;
		this.role = role;
	}
	public User(String firstName, String lastName, String email,String role,String address
			, boolean banned,Long phoneNumber ) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.address = address;
		this.banned = banned;
		this.phoneNumber = phoneNumber;
		
		
	}
	public User(String password, String address, String firstName, String lastName, String email, Long phoneNumber) {
		super();
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public User(String password, String address, String firstName, String lastName, String email, Long phoneNumber,String positionrequest) {
		super();
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.positionrequest=positionrequest;
	}
	public User(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber, boolean banned, List<Auction> auctions, List<Complaint> complaints,
			List<Complaint> responses) {
		super();
		this.idUser = idUser;
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.banned = banned;
		this.auctions = auctions;
		this.complaints = complaints;
		this.responses = responses;
	}
	public User(String password, String address, String firstName, String lastName, String email, Long phoneNumber,
			boolean banned, List<Auction> auctions, List<Complaint> complaints, List<Complaint> responses) {
		super();
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.banned = banned;
		this.auctions = auctions;
		this.complaints = complaints;
		this.responses = responses;
	}
	public User(Integer idUser, String password, String address, String firstName, String lastName, String email,
			Long phoneNumber) {
		super();
		this.idUser = idUser;
		this.password = password;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}   
	public String getPassword() {
		return this.password;
	}

	public List<Auction> getAuctions() {
		return auctions;
	}
	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	public List<Complaint> getResponses() {
		return responses;
	}
	public void setResponses(List<Complaint> responses) {
		this.responses = responses;
	}
	public void setPassword(String password) {
		this.password = password;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPositionrequest() {
		return positionrequest;
	}
	public void setPositionrequest(String positionrequest) {
		this.positionrequest = positionrequest;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((auctions == null) ? 0 : auctions.hashCode());
		result = prime * result + (banned ? 1231 : 1237);
		result = prime * result + ((complaints == null) ? 0 : complaints.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((positionrequest == null) ? 0 : positionrequest.hashCode());
		result = prime * result + ((responses == null) ? 0 : responses.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (auctions == null) {
			if (other.auctions != null)
				return false;
		} else if (!auctions.equals(other.auctions))
			return false;
		if (banned != other.banned)
			return false;
		if (complaints == null) {
			if (other.complaints != null)
				return false;
		} else if (!complaints.equals(other.complaints))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (positionrequest == null) {
			if (other.positionrequest != null)
				return false;
		} else if (!positionrequest.equals(other.positionrequest))
			return false;
		if (responses == null) {
			if (other.responses != null)
				return false;
		} else if (!responses.equals(other.responses))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
   
}
