package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tutorial;

@Repository
public class TutorialDaoImpl implements ITutorialDao {
	//dependency : JPA
	@Autowired
	private EntityManager manager;

	@Override
	public List<String> getTutorialsByTopicId(int topicId) {
		//get all tutorials under specified topic in a sorted as per visits desc  manner
		String jpql="select t.tutorialName from Tutorial t where t.topic.id=:id order by t.visits desc";
		return manager.createQuery(jpql, String.class).setParameter("id", topicId).getResultList();
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateVisits(String tutName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNewTutorial(Tutorial tutorial, int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

}
