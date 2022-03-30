package tester;

import java.sql.*;

public class TestDBConnection {

	public static void main(String[] args) {
		try {
			// load MySql Connector(JDBC DRiver class in method area) : OPTIONAL
//			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
			//API of java.sql.DriverManager class
			//public static Connection getConnection(String url,String userName,String pwd) throws SQLException
			try(Connection cn=DriverManager.getConnection(url, "root", "xelton0003"))
			{
				System.out.println("Connected to DB "+cn);//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
