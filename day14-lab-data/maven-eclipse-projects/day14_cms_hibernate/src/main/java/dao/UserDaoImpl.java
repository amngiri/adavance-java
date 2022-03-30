package dao;

import pojos.User;
import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public User validateUser(String email, String pwd) {
		User user = null;
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

}
