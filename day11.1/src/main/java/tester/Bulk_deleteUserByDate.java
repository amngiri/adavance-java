package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import dao.UserDaoImpl;
import pojos.Role;


public class Bulk_deleteUserByDate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Registration date and role");
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println(dao.deleteUser(LocalDate.parse(sc.next()),Role.valueOf(sc.next().toUpperCase())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}