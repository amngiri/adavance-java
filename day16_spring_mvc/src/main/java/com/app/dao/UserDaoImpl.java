package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository // mandatory annotation to tell SC , following class contains data access logic
public class UserDaoImpl implements IUserDao {
	// dependency : SF
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public User validateUser(String email, String pwd) {
//		User user = null;
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
//		// get session from SF
//		Session session = getFactory().getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			user = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pwd)
//					.getSingleResult();
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			throw e;
//		}
//		return user;
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", pwd).getSingleResult();
	}

}
