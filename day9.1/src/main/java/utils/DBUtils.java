package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;// null
	// add a static method to return SINGLETON (=single instance in the entire Java
	// App) to the caller

	public static Connection openConnection() throws SQLException{
		if (cn == null) {
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url, "root", "xelton0003");
		}
		return cn;
	}
	//add a static method to close connection.
	public static void closeConnection() throws SQLException
	{
		if(cn != null)
			cn.close();
		cn=null;
	}
}
