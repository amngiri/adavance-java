package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import dao.UserDaoImpl;


public class Bulk_UpdateRegAmount {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Registration date and discount");
			UserDaoImpl dao=new UserDaoImpl();
			System.out.println(dao.updateRegAmount(LocalDate.parse(sc.next()), sc.nextDouble()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}