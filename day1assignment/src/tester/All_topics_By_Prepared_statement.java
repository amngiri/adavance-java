package tester;
import static utils.Dbutils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class All_topics_By_Prepared_statement {
	public static void main(String[] args) {
		String sql="select * from topics";
		try(Scanner sc=new Scanner(System.in);
				Connection cn=openConnection();
				PreparedStatement pst=cn.prepareStatement(sql);
				)
		{
			
//			System.out.println("Enter name and password");
//			String name=sc.next();
//			int password=sc.nextInt();
//			pst.setString(1,name);
//			pst.setInt(2,password);
			try(ResultSet rst=pst.executeQuery())
			{
				while (rst.next())
			   {
				   System.out.printf("ID:%d Name: %s"
				   		,rst.getInt(1),rst.getString(2));
				   System.out.println();
				   
			   }
//				else
//				{
//					System.out.println("Wrong ID password");
//				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
