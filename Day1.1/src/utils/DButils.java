package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
//add a static method to return database connections instance
	// instance of the database connection modify the code below to ensure
	// singleton(not a scalable solution wiil be replaced by connection pool
	// from hibernate onwards)
	private static Connection cn;

	public static Connection openConnection() throws SQLException {
		if (cn == null) {
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
			return DriverManager.getConnection(url, "root", "xelton0003");
		}
		return cn;
	}
}
