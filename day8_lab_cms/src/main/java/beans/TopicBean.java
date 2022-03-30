package beans;

import java.sql.SQLException;
import java.util.List;

import dao.TopicDaoImpl;
import pojos.Topic;

public class TopicBean {
	//state (properties)
	//add topic dao ref.
	private TopicDaoImpl topicDao;
	//def ctor
	public TopicBean() throws SQLException{
		System.out.println("in topic bean ctor");
		//create instance of bean's dependency
		topicDao=new TopicDaoImpl();
	}
	//add B.L method to get list of al topics
	public List<Topic> getTopics() throws SQLException
	{
		System.out.println("in B.L method : get topics");
		return topicDao.getAllTopics();
	}

}
