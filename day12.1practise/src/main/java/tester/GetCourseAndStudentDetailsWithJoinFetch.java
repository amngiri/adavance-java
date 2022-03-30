package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;

public class GetCourseAndStudentDetailsWithJoinFetch {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			CourseDaoImpl dao = new CourseDaoImpl();
			System.out.println("Enter course title");
			Course c=dao.getCourseNStudentDetailsJoinFetch(sc.next());
			//c : DETACHED 
			System.out.println("Course details "+c);
			System.out.println("Students enrolled for course "+c.getTitle());
			c.getStudents().forEach(System.out::println);//trying to access fetched data from outside session ctx.
			
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
