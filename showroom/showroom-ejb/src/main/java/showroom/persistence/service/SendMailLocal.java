package showroom.persistence.service;

import javax.ejb.Local;

@Local
public interface SendMailLocal {

	void envoyer(String username, String password, String subjectS, String messageS);

}
