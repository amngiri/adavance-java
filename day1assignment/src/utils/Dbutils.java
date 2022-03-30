package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutils {
private static Connection cn;
public static Connection openConnection() throws SQLException
{
	if(cn==null)
	{
		String sql="jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
		return cn=DriverManager.getConnection(sql,"root","xelton0003");
	}
	return cn;
}
}
