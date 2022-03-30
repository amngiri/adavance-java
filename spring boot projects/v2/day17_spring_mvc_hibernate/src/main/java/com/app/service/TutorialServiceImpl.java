package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITutorialDao;

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

}
