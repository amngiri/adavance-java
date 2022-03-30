package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class ChangePassword {

	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory();) {
			System.out.println("Enter UserID and new password");
			User user=dao.UpdatePassword(sc.nextInt(),sc.next());
			if(user==null)
			{
				System.out.println("No such item present");
			}else
			System.out.println("Password update successfully"+user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
