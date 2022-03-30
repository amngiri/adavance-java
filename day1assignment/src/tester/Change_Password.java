package tester;

import static utils.Dbutils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Change_Password {
	public static void main(String[] args) throws SQLException 
	{
		String sql="update users set password=? where name=? and password=?";
		try(Scanner sc=new Scanner(System.in);
				Connection cn=openConnection();
				PreparedStatement pst=cn.prepareStatement(sql);
				)
		{
			
			System.out.println("Enter name and password");
			String name=sc.next();
			int password=sc.nextInt();
			System.out.println("Enter new password");
			int newpassword=sc.nextInt();
			pst.setInt(1, newpassword);
			pst.setString(2,name);
			pst.setInt(3,password);
			int a=pst.executeUpdate();
//			try(ResultSet rst=pst.executeQuery())
//			{
//				if (rst.next())
//			   {
//					System.out.println("Password successfully update");
//				   System.out.printf("ID: %d Name: %s email: %s password: %d "
//				   		+ "Regamt: %f Regdate: %s Role: %s",rst.getInt(1),rst.getString(2),
//				   		rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getDate(6),rst.getString(7));
//				   
//			        }
//				else
//				{
//					System.out.println("Inavalid user id password");
//				}
			if(a==1)
			{
				System.out.println("password successfully updated");
			}
			else
			{
				System.out.println("Inavlid login details");
			}
			
			}
		catch (Exception e) 
			{
			   e.printStackTrace();
		    }

	}

}

