package tester;

import java.util.Scanner;
import java.sql.*;
import static utils.DButils.openConnection;;

public class TestPreparedStatement {

	public static void main(String[] args) {
		String sql = "select * from my_emp where deptid=? and join_date > ? order by salary";
		try (Scanner sc = new Scanner(System.in);
				// establish db connection
				Connection cn = openConnection();
				// create PST
				PreparedStatement pst = cn.prepareStatement(sql);

		) {
			System.out.println("Enter deptid n date(yr-mon-day)");
			String deptId = sc.next();
			Date joinDate = Date.valueOf(sc.next());
			// set IN params
			pst.setString(1, deptId);
			pst.setDate(2, joinDate);
			// execute the query : public RST executeQuery() throws SQLExc
			try (ResultSet rst = pst.executeQuery()) {
				while (rst.next())
					System.out.printf("Emp Id %d Name %s Address %s Salary %.1f DeptId %s Join Date %s %n",
							rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5),
							rst.getDate(6));

			} //rst.close

		} //pst.close , cn.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
