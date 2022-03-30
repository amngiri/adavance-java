package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class AuthenticateUser {

	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory();) {
			System.out.println("Enter email and password");
			System.out.println(dao.AuthenticateUser(sc.next(),sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
