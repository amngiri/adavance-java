package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDaoImple implements IUserDao {
	private User user1;
	private Connection cn;
	private PreparedStatement pst1;
    public UserDaoImple() throws SQLException
    {
    	cn=openConnection();
    	pst1=cn.prepareStatement("select * from users where name=? and password=?");
    	System.out.println("User dao created");
    }
	@Override
	public User authenticateUser(String name, int password) throws SQLException {
		
		pst1.setString(1, name);
		pst1.setInt(2, password);
		try(ResultSet rst=pst1.executeQuery())
		{
			if (rst.next())
		   {
//			   System.out.printf("ID: %d Name: %s email: %s password: %d "
//			   		+ "Regamt: %f Regdate: %s Role: %s",rst.getInt(1),rst.getString(2),
//			   		rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getDate(6),rst.getString(7));
			   user1=new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getDouble(5),rst.getDate(6),rst.getString(7));
				return user1;
		   }
		}
		return null;
	}
	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
		{
			pst1.close();
		}
	}

}
