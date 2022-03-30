package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
//add a method to insert user details in the db (openSession)
	String registerUser(User user);

	// add a method to insert user details in the db (getCurrentSession)
	String registerUserWithGetCurntSession(User user);
	//add a method to get user details by PK from DB
	User getUserDetails(int userId);
	//add a method to get all user details
	List<User> getAllUserDetails();
	//add a method to get selected user details
	List<User> getSelectedUserDetails(LocalDate beginDate,LocalDate endDate,Role userRole);
	User AuthenticateUser(String email,String password);
	User UpdatePassword(int userId,String newPassword);	
	List<User> getCustomerByDate(LocalDate date, Role rl);
}
