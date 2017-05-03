package artRoom.services2;
import javax.ejb.Stateless;

import artRoom.entities.Admin;
import artRoom.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import artRoom.services2.AdminServiceLocal;
import artRoom.services2.AdminServiceRemote;

/**
 * Entity implementation class for Entity: AdminService
 *
 */
@Stateless

public class AdminService  implements AdminServiceRemote , AdminServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public AdminService() {
		super();
	}
	@Override
	public boolean addAdminstrator(Admin adminstrator) {
		try {
			em.persist(adminstrator);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}

	@Override
	public Admin authentificate1(String email, String password) {
		Admin adminstrator =null;
		Query query = em.createQuery("select a from user a where a.login=:l and a.password=:p and a.role=:admin");  
		query.setParameter("l", email).setParameter("p", password);
		try {
			adminstrator =(Admin) query.getSingleResult();
		} catch (Exception e) {
			adminstrator = null;
		}
		
		
		return adminstrator;
	}
	@Override
	public void banUser(User user, boolean ban) {
		user.setBanned(ban);
		em.merge(user);
	}
	
	@Override
	public User findUserById(Integer idUser) {
		return em.find(User.class, idUser);
	}
	@Override
	public void deleteUserById(Integer idUser) {
		em.remove(findUserById(idUser));
	}
	@Override
	public Long countClients() {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(User.class)));
		return em.createQuery(cq).getSingleResult();
	}
	
}
