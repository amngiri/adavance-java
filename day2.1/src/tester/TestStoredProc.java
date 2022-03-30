package tester;

import java.util.Scanner;

import dao.AccountDaoImpl;

public class TestStoredProc {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			AccountDaoImpl dao = new AccountDaoImpl();
			System.out.println("Enter src dest a/c nos n amount");
			System.out.println(dao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
