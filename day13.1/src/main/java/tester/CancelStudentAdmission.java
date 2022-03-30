package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;
import pojos.Student;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Enter course title");
			String title=sc.next();
			System.out.println("Enter student id");
			
			System.out.println(studentDao.cancelAdmission(title,sc.nextInt()));
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
