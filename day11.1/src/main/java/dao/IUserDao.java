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

	// add a method to get user details by PK from DB
	User getUserDetails(int userId);

	// add a method to get all user details
	List<User> getAllUserDetails();

	// add a method to get selected user details
	List<User> getSelectedUserDetails(LocalDate beginDate, LocalDate endDate, Role userRole);

	// get all user names registered between strt date n end date & under a specific
	// role
	List<String> getSelectedUserNames(LocalDate beginDate, LocalDate endDate, Role userRole);

	// get some of the user details for users registered between strt date n end
	// date & under a specific role
	List<User> getSomeUserDetails(LocalDate beginDate, LocalDate endDate, Role userRole);
	//add a method to un subscribe user
	String unsubscribeUser(int userId);
	//add a method to save image in the db .
	String saveImage(String email , String fileName) throws Exception;
	//add a method to restore image from  the db into a folder
	String restoreImage(int userId, String fileName) throws Exception;
     String updateRegAmount(LocalDate date,double disc);
	String deleteUser(LocalDate date,Role userRole);

}
