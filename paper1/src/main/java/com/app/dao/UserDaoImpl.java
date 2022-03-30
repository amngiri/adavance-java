package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory mgr;

	@Override
	public User validateUser(String email, String pass) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";

		return mgr.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", pass).getSingleResult();
	}

	@Override
	public String registerUser(User u) {
		int statusCode = (Integer) mgr.getCurrentSession().save(u);
		if (statusCode > 0)
			return "User registered";
		return "User registration Failed";
	}

	@Override
	public String getPassword(String name, String email) {
		String jpql = "select u from User u where u.name=:name ";
		User pass = mgr.getCurrentSession().createQuery(jpql, User.class).setParameter("name", name)
				.getSingleResult();
		if (pass != null)
			return pass.getPassword();
		return "no user registered";
	}
}
