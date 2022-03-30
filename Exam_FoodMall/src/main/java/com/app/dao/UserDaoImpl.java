package com.app.dao;


import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository // mandatory annotation to tell SC , following class contains data access logic
public class UserDaoImpl implements IUserDao {
	// dependency : javax.persistence.EntityManager
	@Autowired // byType
	//private EntityManager manager;
private SessionFactory manager;
	@Override
	public User validateUser(String email, String pwd) {
		String jpql="select u from User u where u.email=:em and u.password=:pass";
		
		return manager.createEntityManager().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", pwd).getSingleResult();
	}
	public User registerUser(User u)
	{
		
		return (User) manager.getCurrentSession().save(u);
	}

}
