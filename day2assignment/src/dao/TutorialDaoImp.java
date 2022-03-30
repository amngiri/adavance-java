package dao;
import static utils.DBUtils.openConnection;
import pojos.Tutorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorialDaoImp implements ITutorialDao {
private Connection cn;
private PreparedStatement pst;



	public TutorialDaoImp() throws SQLException {
	cn=openConnection();
	pst=cn.prepareStatement("select name from tutorials where topic_id=? order by visits desc");
	System.out.println("Tutorial dao created");
}



	@Override
	public List<String> getTutorialByVisit(int topicId) throws SQLException {
		pst.setInt(1,topicId);
		List<String> list =new ArrayList<>();
		try(ResultSet rst=pst.executeQuery())
		{
			while(rst.next())
			{
				list.add(rst.getString(1));
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
//		if(cn != null)
//			cn.close();
		System.out.println("emp dao cleaned up!");
	}

}
