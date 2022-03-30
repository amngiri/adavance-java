package tester;
import dao.TutorialDaoImp;
import java.util.List;
import java.util.Scanner;
import pojos.Tutorial;
public class TestTutorial {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in))
		{
			TutorialDaoImp dao=new TutorialDaoImp();
			System.out.println("Enter topic id");
			List<String> list=dao.getTutorialByVisit(sc.nextInt());
			list.forEach(i->System.out.println(i));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
