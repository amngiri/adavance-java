package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import static utils.HibernateUtils.getFactory;
import dao.StudentDaoImpl;
import pojos.Project;

public class LuanchNewProject {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
		Scanner sc=new Scanner(System.in))
		{
	    System.out.println("Enter the project title,technology used and completionDate");
	    StudentDaoImpl dao=new StudentDaoImpl(); 
	    System.out.println(dao.launchNewProject(new Project(sc.next(),sc.next(),LocalDate.parse(sc.next()))));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
