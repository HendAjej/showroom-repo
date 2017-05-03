package showroom.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import artRoom.entities.Complaint;
import artRoom.entities.User;

@Local
public interface ComplaintServicesLocal {

	void addComplaint2(Complaint complaint);
void addComplaint(User complainer, User receiver, String Subject, String message);
	
	User findComplainerById(Integer id);
	
	User findReceiverById(Integer id);

	void deleteComplaint(Complaint complaint) ;

	List<Complaint> findAllComplaints(Integer id);

	Complaint findComplaintById(Integer idComplainer, Integer idReceiver,Date date);

	void deleteComplaintById(Integer idComplainer, Integer idReceiver,Date date);

	User findUser(String name, String email);

	User findUserByName(String name, String lastname);

	List<Complaint> findAllYourComplaints(Integer id);

	List<Complaint> Search(String chaine,Integer id);

	List<Object[]> Statistique();

	List<Complaint> FindAll();

	User findLoger(String email, String password);

}
