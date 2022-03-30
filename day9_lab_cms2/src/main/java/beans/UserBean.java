package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	// properties (non static n non transient instance vars)
	// clnt's conversational state :
	private String email;
	private String password;
	// dependency of JB : user dao
	private UserDaoImpl userDao;
	// to store validated user details
	private User userDetails;
	//add a property to store error message
	private String errMesg;

	// def ctor : which will be called by WC : jsp:useBean
	public UserBean() throws SQLException {
		System.out.println("in user bean ctor");
		// create the dependency : dao instance
		userDao = new UserDaoImpl();
	}

	// add getters n setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	

	public String getErrMesg() {
		return errMesg;
	}

	// Add B.L method for user login(sign in)
	public String authenticateUser() throws SQLException {
		System.out.println("in auth user " + email + " " + password);// clnt's info is already available here...
		// JB has to invoke Dao's method
		userDetails = userDao.validateUser(email, password);
		// how to chk valid or invalid login
		if (userDetails != null) {
			// => valid login ---continue to role based authorization
			if (userDetails.getRole().equals("customer")) // => customer login
				return "topics";
			// => admin login
			return "show_tutorial_form";

		}
		// => invalid login
		errMesg="Invalid Login , Please retry .....";
			return "login";// dynamic navigational outcome
	}

}
