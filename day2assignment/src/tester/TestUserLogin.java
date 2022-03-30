package tester;
import java.util.Scanner;

import dao.UserDaoImple;
import pojos.User;
public class TestUserLogin {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			UserDaoImple dao=new UserDaoImple();
			System.out.println("Enter the name and password");
			User check=dao.authenticateUser(sc.next(), sc.nextInt());
			if(check!=null)
			System.out.println(check);
			else
				System.out.println("Invalid login passoword");
			dao.cleanUp();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
