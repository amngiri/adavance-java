package com.app.dao;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialDao {
//get all tutorials under specified topic in a sorted as per visits manner
	List<String> getTutorialsByTopicId(int topicId);

//get tutorial details
	Tutorial getTutorialDetails(String tutName);

	// update visits
	// String updateVisits(String tutName);

//	// add new tutorial
//	String addNewTutorial(Tutorial tutorial, int topicId);

	// deleting a tutorial from the topic
	void deleteTutorial(String tutname);

	void addTutorialsByTopic(int topicId, Tutorial t);

	void updatetutorial(int topicId, Tutorial t);
}
