
package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Tutorial2;

public class TutorialDaoImpl2 implements ITutorialDao2 {
	private Tutorial2 tutorial1;
	private Connection cn;
	private PreparedStatement pst1;
    public TutorialDaoImpl2() throws SQLException
    {
    	cn=openConnection();
    	pst1=cn.prepareStatement("select * from tutorials where name=?");
    	System.out.println("TutorialDao 2  dao created");
    }
	@Override
	public Tutorial2 getTutorialByName(String name) throws SQLException {
		
		pst1.setString(1, name);
		try(ResultSet rst=pst1.executeQuery())
		{
			if (rst.next())
		   {
				//id | name        | author | publish_date | visits | contents                     | topic_id
//				  System.out.printf("ID: %d Name: %s author: %s date: %s "
//					   		+ "vist: %d  Role: %s TopicId: %d",rst.getInt(1),rst.getString(2),
//					   		rst.getString(3),rst.getDate(4),rst.getInt(5),rst.getString(6),rst.getInt(7));
			   tutorial1=new Tutorial2(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDate(4),rst.getInt(5),rst.getString(6),rst.getInt(7));
				return tutorial1;
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
