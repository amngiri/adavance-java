package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;

import static java.time.LocalDate.parse;

import pojos.Address;
import pojos.AdharCard;
import pojos.Course;
import pojos.EduType;
import pojos.EducationalQualifications;
import pojos.Student;

public class AssignCompleteStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Enter student email");
			String email = sc.next();
			System.out.println("Enter address details : city state country zip code");
			Address a = new Address(sc.next(), sc.next(), sc.next(), sc.next());
			System.out.println("Enter adhar card details : card number , creation date , location");
			AdharCard card = new AdharCard(sc.next(), LocalDate.parse(sc.next()), sc.next());
			sc.nextLine();
			List<String> hobbyList = new ArrayList<>();
			System.out.println("Enter hobbies in a single line , space separated ");
			String hobbies = sc.nextLine();// reading music trekking
			Scanner sc2 = new Scanner(hobbies);
			while (sc2.hasNext())
				hobbyList.add(sc2.next());
			System.out.println("hobbies " + hobbyList);
			List<EducationalQualifications> quals = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter edu qualifications : type  year marks");
				quals.add(new EducationalQualifications(EduType.valueOf(sc.next().toUpperCase()), sc.nextInt(),
						sc.nextInt()));
			}
			System.out.println(quals);
			//call dao layer method , to reflect SAME object graph in DB
			System.out.println(studentDao.insertCompleteStudentDetails(email, a, card, hobbyList, quals));

		} // sf.close() => close conn pool : clean up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
