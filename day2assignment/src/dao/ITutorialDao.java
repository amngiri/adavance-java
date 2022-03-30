package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Tutorial2;

public interface ITutorialDao {
List<String> getTutorialByVisit(int topic_id) throws SQLException;

}
