package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Topic;

public interface ITopicDoa {
List<Topic> getAllTopic() throws SQLException;
}
