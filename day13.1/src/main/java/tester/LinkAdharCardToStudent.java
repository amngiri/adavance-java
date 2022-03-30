package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;

import static java.time.LocalDate.parse;

import pojos.AdharCard;
import pojos.Course;
import pojos.Student;

public class LinkAdharCardToStudent {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Enter student id");
			int id = sc.nextInt();
			System.out.println("Enter adhar card details : card number , creation date , location");

			System.out.println(
					studentDao.linkAdharCard(id, new AdharCard(sc.next(), LocalDate.parse(sc.next()), sc.next())));
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
