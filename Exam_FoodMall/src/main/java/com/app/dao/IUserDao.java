package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	User validateUser(String email,String pwd);
   User registerUser(User u);
}
