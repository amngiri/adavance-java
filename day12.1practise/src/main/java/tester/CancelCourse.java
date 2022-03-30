package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;

public class CancelCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			CourseDaoImpl dao = new CourseDaoImpl();
			System.out.println("Enter course id");
			System.out.println(dao.cancelCourse(sc.nextInt()));
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
