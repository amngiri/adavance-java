package utils;

import java.sql.*;

public class DBUtils {
//add a static method to return DB connection instance
	// modify the code below , to ensure SINGLETON instance of the DB connection
	// (not a scalable solution, will be replaced by connection pool , from
	// hibernate onwards)
	private static Connection cn;

	public static Connection openConnection() throws SQLException {
		if (cn == null) {
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url, "root", "xelton0003");
		}
		return cn;
	}
}
