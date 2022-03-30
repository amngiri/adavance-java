package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Course;
import pojos.Student;

public class LaunchNewCourseWithStudents {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			CourseDaoImpl dao = new CourseDaoImpl();
			System.out.println("Enter new course details : title,  startDate,  endDate,  fees,  capacity");
			Course c = new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt());
			//accept student details : 3
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter student details : name email");
				Student s1=new Student(sc.next(), sc.next());
				c.addStudent(s1);//establishing bi-dir link				
			}
			System.out.println(dao.launchNewCourse(c));
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
