package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.bank.Account;

public class TestBefore {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
				"spring-config.xml")) {
			System.out.println("sc started....");
			Account a1 = ctx.getBean("acct", Account.class);
			System.out.println(a1.getClass().getName());
			a1.withdraw(100);
	//		System.out.println("Summary "+a1.getSummary());
		} catch (Exception e) {
			System.out.println("err " + e.getMessage());
			// e.printStackTrace();
		}

	}

}
