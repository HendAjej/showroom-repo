package artRoom.services2;

import artRoom.entities.Admin;
import artRoom.entities.User;

public interface AdminServiceRemote {
	User findUserById(Integer idUser);
	void deleteUserById(Integer idUser);		
	void banUser(User user, boolean ban);
	Long countClients();
	boolean addAdminstrator(Admin adminstrator);
	Admin authentificate1(String email, String password);

}
