package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class TestSessionAPI {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("hibernate up n running !" + sf);
			System.out.println(
					"Enter user details :  name,  email,  password,  confirmPassword,  userRole,  regAmount, regDate(yr-mon-day)");
			User u=new User(sc.next(), sc.next(), sc.next(), sc.next(),
					Role.valueOf(sc.next().toUpperCase()) ,sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println("user id "+u.getUserId());//null
			u.setUserId(5);
			System.out.println(dao.registerUserWithGetCurntSession(u));
			
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
