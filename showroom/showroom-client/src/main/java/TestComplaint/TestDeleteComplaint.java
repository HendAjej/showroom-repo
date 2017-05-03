package TestComplaint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import showroom.persistence.service.*;
import artRoom.entities.*;

public class TestDeleteComplaint {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ComplaintServicesRemote complaintServicesRemote = (ComplaintServicesRemote) context.lookup(
				"showroom-ear/showroom-ejb/ComplaintServices!showroom.persistence.service.ComplaintServicesRemote");

		

		// Date t = new Date(2017, 04, 27,17,35,34);
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	        Date d=null;
			try {
				d = df.parse("2017-04-27 17:35:34.0");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(d);

Complaint complaint=complaintServicesRemote.findComplaintById(1,2,d );
System.out.println(complaint);
			
			complaintServicesRemote.deleteComplaint(complaint);
		
	}
}
