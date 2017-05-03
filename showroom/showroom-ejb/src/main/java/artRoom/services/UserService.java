package artRoom.services;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import artRoom.entities.Artist;
import artRoom.entities.User;
import javax.persistence.Query;


/**
 * Entity implementation class for Entity: UserService
 *
 */
@Stateless

public class UserService implements UserServiceRemote , UserServiceLocal {
	@PersistenceContext
	private EntityManager em;


	
	

	public UserService() {
		super();
	}
	
	/*@Override
	public User login(String firstName, String password) {
		User user = null;
		try {
			user = (User) em.createQuery("select u from User u where u.login=:param1 and u.password=:param2")
					.setParameter("param1", firstName).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("login method");
		System.out.println("user:"+user.getFirstName());

		return user;
	}*/
	@Override
	public User login(String firstName, String password) {
		User user = null;
		try {
			user = (User) em.createQuery("select u from User u where u.email=:param1 and u.password=:param2")
					.setParameter("param1", firstName).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("login method");
		//System.out.println("user:"+user.getEmail());

		return user;
	}
	@Override
	public Boolean addUser(User user) {
		Boolean b = false;
		try {
			em.persist(user);
			b = true;
		} catch (Exception e) {

			System.err.println("problem in subscription ...");
		}
		return b;
	}
	@Override

public void addUser1( User user) {
		em.persist(user);
	}
	@Override
public User Authentification(String  firstname, String password) {
		
		User user = null;
		try {
			user = (User) em.createQuery("SELECT u FROM User u WHERE u.firstName=:firstName AND u.password=:password",User.class)
					.setParameter("firstName", firstname).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;	
} 
@Override
	public boolean loginUser(String firstName, String password) {
		User user = findByUsername(firstName);
		if (user == null) {
			return false;
		} else if (user.getPassword().equals(password)) {
			if ((!user.isBanned())) {
				return true;
			}
			return false;

		}
		return false;

	}
@Override
public User findUserByUsername(String firstName) {
	TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.firstName=:firstName",User.class);
	query.setParameter("firstName", firstName);
	try {
		System.out.println("found");
		User user = query.getSingleResult();	
		return user;
		
	} catch (Exception e) {
		return null;
	}
}
@Override
public User findByUsername(String firstName) {
	try {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u where u.firstName =:firstName", User.class);
		q.setParameter("firstName", firstName);
		User user = q.getSingleResult();
		return user;
	} catch (javax.persistence.NoResultException e) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO,
				"User with firstName = " + firstName + " not found");
		return null;
	}

}
	@Override
	public Boolean banUser1 (User user) {

		try {

			user.setBanned(true);
			em.merge(user);

			System.out.println("the user is now banned!!!");

			return true;
		} catch (Exception e) {
			System.out.println("invalid ban process !!!");

			return false;
		}

	}
@Override
	public Boolean UnbanUser(User user) {
		try {

			user.setBanned(false);
			em.merge(user);

			System.out.println("the user is now unbanned!!!");

			return true;
		} catch (Exception e) {
			System.out.println("invalid ban process !!!");

			return false;
		}
	}
	@Override
	public User findUserById(Integer idUser) {
		return em.find(User.class, idUser);
	}
	@Override
	public void deleteUserById(Integer idUser) {
		em.remove(findUserById(idUser));
		System.out.println("user deleted !!!");
	}

	@Override
	public User findUserByUsernameAndPassword(String firstName, String password) {
		TypedQuery<User> query = em.createQuery("SELECT s FROM User s where ( s.firstName=?1 and s.password=?2 )",
				User.class);
		query.setParameter(1, firstName);
		query.setParameter(2, password);
		if (query.getResultList().size() > 0) {
			return (User) query.getSingleResult();
		} else {
			return null;
		}
	}
	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createQuery("SELECT s FROM User s where ( s.email=?1 and s.password=?2 )",
				User.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		if (query.getResultList().size() > 0) {
			return (User) query.getSingleResult();
		} else {
			return null;
		}
	}
	@Override
	public User findUserByName(String firstName) {
		TypedQuery<User> query = em.createQuery("SELECT s FROM User s where ( s.firstName=?1 )",
				User.class);
		query.setParameter(1, firstName);
		if (query.getResultList().size() > 0) {
			return (User) query.getSingleResult();
		} else {
			return null;
		}
	}
	
	@Override
	public List<User> findUserByRole(String role) {
		
		TypedQuery<User> query = em.createQuery("select u from User u where u.role=:l", User.class);
		query.setParameter("l", role);
		return (List<User>) query.getResultList();
	}
	@Override
	public List<User> findUsersNotAdmin() {
		Query query= em.createQuery("select u from User u where u.role=: galleryowner  ", User.class);
		return query.getResultList();
	}
	@Override
	public User authentificate(String email, String password) {
		System.out.println("method athentificate");
		User user=null;
		Query query=em.createQuery("select u from User u where u.email=:l and u.password=:p");
		query.setParameter("l", email).setParameter("p", password);
		try {
			user=(User) query.getSingleResult();
		} catch (Exception e) {
			user=null;
		}
		System.out.println("authe ok ");

		return user;
	}
	@Override
	public List<User> findAllUsersByCriteria(String text, String searchby, String orderby) {
		TypedQuery<User> query = em.createQuery(
				"SELECT u FROM User u where u." + searchby + " like ?1 order by u." + orderby + " desc", User.class);
		query.setParameter(1, "%" + text + "%");
		return (List<User>) query.getResultList();
	}
	@Override
	public List<User> findAllUsers() {
		Query query= em.createQuery("select u from User u");
		return query.getResultList();
	}
	@Override
	public Long countArtists() {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(Artist.class)));
		return em.createQuery(cq).getSingleResult();
	}

	@Override
	public Long countClients() {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(User.class)));
		return em.createQuery(cq).getSingleResult();
	}

	public ArrayList<User>  doFindUserByByRole (String role){
		Query query= em.createQuery("select u from User u where u.role=?1");
		return (ArrayList<User>) query.getResultList();
		
	}
	@Override
	public ArrayList<User> findUserByRole1 (String role) {
		Query querygetuserbyrole= em.createNamedQuery("getuserbyrole");
		querygetuserbyrole.setParameter("role",role);
		return (ArrayList<User>)querygetuserbyrole.getResultList();
	}

	@Override
	public boolean UsernameExists(String firstName) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.firstName=?1", User.class);
		query.setParameter(1, firstName);
		if (query.getResultList().size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteUser(User user)  {
		em.remove(em.merge(user));
	}


	@Override
	public void updateUser(User user){
		em.merge(user);
	}

	 @Override
	    public List<User> findAllUsersByValue(String search_userValue, String searchValue, String sortValue) throws Exception {
	        try
	        {
	            return findAllUsersByCriteria(search_userValue, searchValue, sortValue);
	        }
	        catch(Exception e)
	        {
	            throw e;
	        }
	    }
	@Override
	public ArrayList<User> getList() {
		return (ArrayList<User>) em.createQuery("select c from user c where c.role!='admin'").getResultList();
		
	}
	
	  @Override
	    public List<User> findAllUsers(String orderby) {
	        TypedQuery<User> query = em.createQuery("SELECT u FROM User u order by u." + orderby + " desc", User.class);
	        List<User> users = query.getResultList();
	        for (User user1 : users) {
	            User user = new User();
	            if (user.getClass().equals(user.getClass())) {
	                user = (User) user1;
	            }

	        }
	        return users;
	    }
	 @Override
	    public List<User> findAllUsersSortBy(String sortValue) throws Exception {
	        try
	        {
	            return findAllUsers(sortValue);
	        }
	        catch(Exception e)
	        {
	            throw e;
	        }
	    }

	 @Override
		public void enableUser(User user) {
			user.setActive(true);
			updateUser(user);

		}
	 @Override
		public User findByEmail(String email) {
			try {
				TypedQuery<User> q = em.createQuery("SELECT u FROM User u where u.email =:email", User.class);
				q.setParameter("email", email);
				User user = q.getSingleResult();
				return user;
			} catch (javax.persistence.NoResultException E) {
				Logger.getLogger(this.getClass().getName()).log(Level.INFO, "User with email = " + email + " not found");
				return null;
			}
		}
		@Override
		public boolean verifyMail(String mail) {
			String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
					+ "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
			Pattern pattern = Pattern.compile(masque);
			Matcher controler = pattern.matcher(mail);
			if (controler.matches()) {
				return true;
			} else {
				return false;
			}

		}

}
