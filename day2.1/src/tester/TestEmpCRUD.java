package tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class TestEmpCRUD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create emp dao instance : init phase of the app
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Get Emp Details 2. Insert Emp details 3.Update Emp Details "
						+ "4. Delete Emp Details 5. Display avg sal by dept 10. Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // get emp details
						System.out.println("Enter dept begin date n end date(yr-mon-day)");
						List<Employee> empList = dao.getSelectedEmpDetails(sc.next(), Date.valueOf(sc.next()),
								Date.valueOf(sc.next()));
						empList.forEach(System.out::println);
						break;
					case 2:
						System.out.println(
								"Enter emp details : name    | addr    | salary | deptid | join_date(yr-mon-day)");
						System.out.println(dao.insertEmpDetails(new Employee(sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), Date.valueOf(sc.next()))));
						break;
					case 3:
						System.out.println("Enter empId, salIncr, newDept");
						System.out.println(dao.updateEmpDetails(sc.nextInt(), sc.nextDouble(), sc.next()));
						break;
					case 4:
						System.out.println("Enter emp id to remove emp details");
						System.out.println(dao.deleteEmpDetails(sc.nextInt()));
						break;
					case 5:
						dao.getAvgSalaryByDept()
								.forEach((dept, sal) -> System.out.println("Dept : " + dept + " Avg Sal " + sal));
						break;

					case 10:
						exit = true;
						// destroy (shut down) : clean up db resources
						dao.cleanUp();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
