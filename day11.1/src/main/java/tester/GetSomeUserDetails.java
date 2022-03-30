package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class GetSomeUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("hibernate up n running !" + sf);
			System.out.println("Enter strt date end date n role");
			System.out.println("List of selected  users ");
			dao.getSomeUserDetails(LocalDate.parse(sc.next()), LocalDate.parse(sc.next()),
					Role.valueOf(sc.next().toUpperCase())).forEach(System.out::println);

		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
