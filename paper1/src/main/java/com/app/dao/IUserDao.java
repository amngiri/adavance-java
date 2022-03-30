package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	User validateUser(String email, String pass);
	
	String registerUser(User u);
	
	String getPassword(String name, String email);
}
