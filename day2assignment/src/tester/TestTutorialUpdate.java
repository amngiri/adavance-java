package tester;

import java.util.Scanner;
import dao.TutorialDaoUpdateImpl;
import pojos.TutorialUpdate;

public class TestTutorialUpdate {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			TutorialDaoUpdateImpl dac=new TutorialDaoUpdateImpl();
			System.out.println("Enter tutorialID id and Enter new no of visits");
			String temp=dac.updateVisit(sc.nextInt(),sc.nextInt());
			System.out.println(temp);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
