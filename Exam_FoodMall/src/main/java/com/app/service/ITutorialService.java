package com.app.service;

import java.util.List;

import com.app.pojos.Items;

public interface ITutorialService {
	List<String> getTutorialsByTopic(int topicId);

//	Items getUpdatedTutDetails(String tutName);
}
