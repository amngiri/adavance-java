package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3,pst4,pst5;

	public TutorialDaoImpl() throws ClassNotFoundException, SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("select name from tutorials where topic_id=? order by visits desc");
		pst2 = cn.prepareStatement("select * from tutorials where name=?");
		pst3 = cn.prepareStatement("update tutorials set visits=visits+1 where id=?");
		pst4 =cn.prepareStatement("Select id from topics where name=?");
		pst5 =cn.prepareStatement("insert into tutorials values(default,?,?,?,?,?,?)");
		System.out.println("tut dao created");
	}

	@Override
	public List<String> getTutorialsByTopicId(int topicId) throws SQLException {
		List<String> tutNames = new ArrayList<>();
		pst1.setInt(1, topicId);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				tutNames.add(rst.getString(1));
		}
		return tutNames;
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) throws SQLException {
		pst2.setString(1, tutName);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next())
				return new Tutorial(rst.getInt(1), tutName, rst.getString(3), rst.getDate(4), rst.getInt(5),
						rst.getString(6), rst.getInt(7));
		}
		return null;
	}

	@Override
	public String updateVisits(int tutorialId) throws SQLException {
		// set IN param
		pst3.setInt(1, tutorialId);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "visits updated...";
		return "sists updation failed...";
	}
	
	@Override
	public int getIdByName(String name) throws SQLException {
		pst4.setString(1, name);
		try(ResultSet rst=pst4.executeQuery())
		{
			while(rst.next())
			{
				return rst.getInt(1);
			}
		}
		return 0;
	}
	@Override
	public String insertTutorial(Tutorial tut) throws SQLException {
//id | name| author | publish_date | visits | contents| topic_id
		pst5.setString(1,tut.getTutorialName());
		pst5.setString(2, tut.getAuthor());
		pst5.setDate(3,tut.getPublishDate());
		pst5.setInt(4, tut.getVisits());
		pst5.setString(5, tut.getContents());
		pst5.setInt(6, tut.getTopicId());

		int updateCount=pst5.executeUpdate();
		if(updateCount == 1)
			return "New tutorial inserted ....";		
		return "Tutorial insertion failed....";
	}
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if(pst4!=null)
			pst4.close();
		if(pst5!=null)
			pst5.close();
		System.out.println("tut dao cleaned up...");
	}

	

}
