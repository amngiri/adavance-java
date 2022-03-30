package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class RegisterNewUserWithGetCurrentSession {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			//create dao instance
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println("hibernate up n running !" + sf);
			System.out.println(
					"Enter user details :  name,  email,  password,  confirmPassword,  userRole,  regAmount, regDate(yr-mon-day)");
			System.out.println(dao.registerUserWithGetCurntSession(new User(sc.next(), sc.next(), sc.next(), sc.next(),
					Role.valueOf(sc.next().toUpperCase()) ,sc.nextDouble(), LocalDate.parse(sc.next()))));
			
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
