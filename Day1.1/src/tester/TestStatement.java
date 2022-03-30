package tester;

import static utils.DButils.openConnection;
import java.sql.*;

public class TestStatement {

	public static void main(String[] args) {
		try(Connection conn=openConnection();
				//create empty Statement object , to hold query )
				Statement st=conn.createStatement();
				//execute the select query : public ResultSet executeQuery(String sql) throws SQLExc.
				ResultSet rst=st.executeQuery("select * from my_emp");)
		{
			while(rst.next())
				System.out.printf("Emp Id %d Name %s Address %s Salary %.1f DeptId %s Join Date %s %n",
						rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getDate(6));
			
		} //rst.close , st.close , cn.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
