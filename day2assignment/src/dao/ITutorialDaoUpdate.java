package dao;

import java.sql.SQLException;

public interface ITutorialDaoUpdate {
	String updateVisit(int topicId,int updatedVisit) throws SQLException;
}
