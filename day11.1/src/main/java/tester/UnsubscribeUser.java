package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class UnsubscribeUser {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("hibernate up n running !" + sf);
			System.out.println("Enter user id to delete user details");
			System.out.println(dao.unsubscribeUser(sc.nextInt()));

		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
