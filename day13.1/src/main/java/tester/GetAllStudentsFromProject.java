package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

public class GetAllStudentsFromProject {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter project title");
			dao.DisplayAllStudentWorkingInProject(sc.next()).forEach(i->System.out.println(i));
			//dao.DisplayAllStudentWorkingInProject(sc.next()).forEach(u->u.getHobbies().forEach(System.out::println)); 
			//(getting hobbies of student by project title)
		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
