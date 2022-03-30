package tester;
import dao.TutorialDaoImpl2;
import java.util.List;
import java.util.Scanner;
import pojos.Tutorial2;
public class TestTutorial2 {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in))
		{
			TutorialDaoImpl2 dao=new TutorialDaoImpl2();
			System.out.println("Enter topic name");
			Tutorial2 tutorial=dao.getTutorialByName(sc.nextLine());
			System.out.println(tutorial);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
