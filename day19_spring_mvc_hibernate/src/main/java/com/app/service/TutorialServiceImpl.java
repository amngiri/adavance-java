package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITutorialDao;
import com.app.pojos.Tutorial;

@Service
@Transactional
public class TutorialServiceImpl implements ITutorialService {
	// dependency
	@Autowired
	private ITutorialDao tutorialDao;

	@Override
	public List<String> getTutorialsByTopic(int topicId) {
		// TODO Auto-generated method stub
		return tutorialDao.getTutorialsByTopicId(topicId);
	}

	@Override
	public Tutorial getUpdatedTutDetails(String tutName) {
		Tutorial tutorial = tutorialDao.findByTutorialName(tutName)
				.orElseThrow(() -> new RuntimeException("No tutorial found by name " + tutName));
		// => tutorial found : PERSISTENT
		tutorial.setVisits(tutorial.getVisits() + 1);// updating state of the PERSISTENT pojo
		return tutorial;
	}// tx committed : auto dirty chking : update

}
