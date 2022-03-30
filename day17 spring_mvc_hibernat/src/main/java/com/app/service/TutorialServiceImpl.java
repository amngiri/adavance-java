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
	//dependency 
	@Autowired
	private ITutorialDao tutorialDao;

	@Override
	public List<String> getTutorialsByTopic(int topicId) {
		// TODO Auto-generated method stub
		return tutorialDao.getTutorialsByTopicId(topicId);
	}

	@Override
	public Tutorial getUpdatedTutDetails(String tutName) {
		Tutorial tutorial=tutorialDao.getTutorialDetails(tutName);
		//=> tutorial found : PERSISTENT
		tutorial.setVisits(tutorial.getVisits()+1);
		return tutorial;
	}//tx  committed : auto dirty chking : update

	@Override
	public void delete_Tutorial(String tutName) {
		tutorialDao.deleteTutorial(tutName);
		

	}

	@Override
	public void addTutorialsByTopic(int topicId, Tutorial t) {
		tutorialDao.addTutorialsByTopic(topicId,t);
		
	}

	@Override
	public void updateTutorialsByTopic(int topicId, Tutorial t) {
		tutorialDao.updatetutorial(topicId,t);
		
	}

	



}
