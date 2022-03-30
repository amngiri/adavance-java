package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class GetAllUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("hibernate up n running !" + sf);
			System.out.println("List of users ");
			dao.getAllUserDetails().forEach(System.out::println);

		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
