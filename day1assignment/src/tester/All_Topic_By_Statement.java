package tester;
import static utils.Dbutils.openConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class All_Topic_By_Statement {

	public static void main(String[] args) {
		try(Connection cn=openConnection();
				Statement st=cn.createStatement(); //it is not safe
				ResultSet rst=st.executeQuery("select * from topics");)
		{
			while(rst.next())
			{
				System.out.printf("ID: %d Name: %s",rst.getInt(1),rst.getString(2));
				System.out.println();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
