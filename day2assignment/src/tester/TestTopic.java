package tester;

import java.util.List;

import dao.TopicDaoImp;
import pojos.Topic;

public class TestTopic {

	public static void main(String[] args) {
		try {
		TopicDaoImp dao=new TopicDaoImp();
		List<Topic> list=dao.getAllTopic();
		list.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
