package tester;
import static utils.Dbutils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login_Validation_By_JDBC {
	public static void main(String[] args) {
		String sql="select * from users where name=? and password=?";
		try(Scanner sc=new Scanner(System.in);
				Connection cn=openConnection();
				PreparedStatement pst=cn.prepareStatement(sql); //
				)
		{
			
			System.out.println("Enter name and password");
			String name=sc.next();
			int password=sc.nextInt();
			pst.setString(1,name);
			pst.setInt(2,password);
			try(ResultSet rst=pst.executeQuery())
			{
				if (rst.next())
			   {
				   System.out.printf("ID: %d Name: %s email: %s password: %d "
				   		+ "Regamt: %f Regdate: %s Role: %s",rst.getInt(1),rst.getString(2),
				   		rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getDate(6),rst.getString(7));
				   
			   }
				else
				{
					System.out.println("Wrong ID password");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
