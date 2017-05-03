package TestComplaint;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import showroom.persistence.service.*;
import artRoom.entities.Complaint;
import artRoom.entities.User;

public class TestAddComplaint {
	
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ComplaintServicesRemote complaintServicesRemote = (ComplaintServicesRemote) context.lookup(
				"showroom-ear/showroom-ejb/ComplaintServices!showroom.persistence.service.ComplaintServicesRemote");
				
		User complainer = complaintServicesRemote.findComplainerById(2);
		User receiver = complaintServicesRemote.findReceiverById(3);
		String Subject = "retard livraison";
		String message = "Bonjour monsieur j'ai été prevenu que je vais recevoir mon tableau...";
		complaintServicesRemote.addComplaint(complainer, receiver, Subject, message);
		
		Complaint com= new Complaint( Subject, message,complainer, receiver);
		//complaintServicesRemote.addComplaint2(com);
		

		
		User complainer9 = complaintServicesRemote.findComplainerById(3);
		User receiver9 = complaintServicesRemote.findReceiverById(2);
		String Subject9 = "retard livraison";
		String message9 = "Bonjour monsieur j'ai été prevenu que je vais recevoir mon tableau...";
		complaintServicesRemote.addComplaint(complainer9, receiver9, Subject9, message9);
	}

}
