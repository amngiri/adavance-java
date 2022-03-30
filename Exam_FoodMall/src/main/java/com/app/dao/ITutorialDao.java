package com.app.dao;

import java.util.List;

import com.app.pojos.Items;

public interface ITutorialDao {
//get all tutorials under specified topic in a sorted as per visits manner
	List<String> getTutorialsByTopicId(int topicId);

//get tutorial details
//	Items getTutorialDetails(String tutName);

	// update visits
	//String updateVisits(String tutName);

	// add new tutorial
//	String addNewTutorial(Items tutorial,int topicId);
}
