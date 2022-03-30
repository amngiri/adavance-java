package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory())
		{
//			getFactory();
//			getFactory();
			System.out.println("Hibernate frmwork up n running ...."+sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
