package artRoom.services;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import artRoom.entities.User;

@Remote
public interface UserServiceRemote {
	
    	Boolean addUser(User user);
        void updateUser(User user) ;
	    boolean UsernameExists(String username);
	    List<User> findAllUsersByValue(String search_userValue, String searchValue, String sortValue) throws Exception;
		User findUserByUsernameAndPassword(String firstName, String password);
		List<User> findAllUsersByCriteria(String text, String searchby, String orderby);
		Long countArtists();
		void deleteUserById(Integer idUser);
		User findUserById(Integer idUser);
		Boolean UnbanUser(User user);
		void addUser1(User user);
		Boolean banUser1(User user);
		User authentificate(String email, String password);
		Long countClients();
		List<User> findAllUsers();
		void deleteUser(User user) ;
		List<User> findUsersNotAdmin();
		ArrayList<User> getList();
		List<User> findUserByRole(String role);
		ArrayList<User> findUserByRole1(String role);
		User findUserByName(String firstName);
		boolean loginUser(String firstName, String password);
		User findByUsername(String firstName);
		User Authentification(String firstname, String password);
		User findUserByUsername(String firstName);
		User login(String firstName, String password);
		void enableUser(User user);


}


