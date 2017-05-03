package artRoom.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import artRoom.entities.User;
@Local
public interface UserServiceLocal {
		Boolean addUser(User user);
		void addUser1(User user);
		User findUserByUsernameAndPassword(String firstName, String password);
		List<User> findAllUsersByCriteria(String text, String searchby, String orderby);
		Long countArtists();
		void updateUser(User user);
		void deleteUserById(Integer idUser);
		User findUserById(Integer idUser);
		Boolean banUser1(User user);
		Boolean UnbanUser(User user);
		User authentificate(String email, String password);
		Long countClients();
		List<User> findAllUsers();
		void deleteUser(User user) ;
		List<User> findUsersNotAdmin();
		ArrayList<User> getList();
		List<User> findUserByRole(String role) ;
		ArrayList<User> findUserByRole1(String role);
		User findUserByName(String firstName);
		boolean loginUser(String firstName, String password);
		User findByUsername(String firstName);
		User Authentification(String firstname, String password);
		User findUserByUsername(String firstName);
		List<User> findAllUsers(String orderby);
		List<User> findAllUsersSortBy(String sortValue) throws Exception;
		List<User> findAllUsersByValue(String search_userValue, String searchValue, String sortValue) throws Exception;
		 User login(String firstName, String password) ;
		void enableUser(User user);
		User findByEmail(String email);
		boolean verifyMail(String mail);
		User findUserByEmailAndPassword(String email, String password);
		

	}

