package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory mgr;

	@Override
	public User validateUser(String email, String pass) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";

		return mgr.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", pass).getSingleResult();
	}
}
