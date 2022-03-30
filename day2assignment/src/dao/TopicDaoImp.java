package dao;
import static utils.DBUtils.openConnection;
import pojos.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImp implements ITopicDoa {
private Connection cn;
private PreparedStatement pst;



	public TopicDaoImp() throws SQLException {
	cn=openConnection();
	pst=cn.prepareStatement("select * from topics");
	System.out.println("topics dao created");
}



	@Override
	public List<Topic> getAllTopic() throws SQLException {
		List<Topic> list =new ArrayList<>();
		try(ResultSet rst=pst.executeQuery())
		{
			while(rst.next())
			{
				list.add(new Topic(rst.getInt(1),rst.getString(2)));
//				 System.out.printf("ID:%d Name: %s"
//					   		,rst.getInt(1),rst.getString(2));
//					   System.out.println();
			}
		}
		return list;
	}
	public void cleanUp() throws SQLException
	{
		if(pst != null)
			pst.close();
		if(cn != null)
			cn.close();
		System.out.println("emp dao cleaned up!");
	}

}
