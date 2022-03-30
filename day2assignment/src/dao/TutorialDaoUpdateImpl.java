
package dao;
import static utils.DBUtils.openConnection;
import pojos.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorialDaoUpdateImpl implements ITutorialDaoUpdate {
private Connection cn;
private PreparedStatement pst;



	public TutorialDaoUpdateImpl() throws SQLException {
	cn=openConnection();
	pst=cn.prepareStatement("update tutorials set visits=? where id=?");
	System.out.println("topics dao created");
}



	@Override
	public String updateVisit(int tutorialId,int updatedVisit) throws SQLException {
		pst.setInt(1, updatedVisit);
		pst.setInt(2, tutorialId);
		int check=pst.executeUpdate();
		if(check==1)
		{
			return "SuccessfullyUpdated";
		}
		else
		{
			return "UnSuccessfullattemt";
		}
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
