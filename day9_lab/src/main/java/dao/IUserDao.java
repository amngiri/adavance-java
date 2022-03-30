package dao;

import pojos.User;

public interface IUserDao {
//add a method to insert user details in the db
	String registerUser(User user);
}
