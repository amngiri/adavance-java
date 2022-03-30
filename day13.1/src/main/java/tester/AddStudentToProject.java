package tester;
	import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

	public class AddStudentToProject {

		public static void main(String[] args) {
			try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
				System.out.println("hibernate up n running !" + sf);
				StudentDaoImpl dao = new StudentDaoImpl();
				//both student and project that will be provided will already be existing
				System.out.println("Enter student email and project title to add student into the project");
				System.out.println(dao.addStudentToProject(sc.next(), sc.next()));
			} // sf.close() => close conn pool : clean up !
			catch (Exception e) {
				e.printStackTrace();
			}

		}
}
