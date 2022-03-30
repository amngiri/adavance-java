package com.app.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Topic;
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
		String jpql="select t from Tutorial t where  t.tutorialName=:name";
		return manager.createQuery(jpql,Tutorial.class).setParameter("name", tutName).getSingleResult();
	}

//	@Override
//	public String updateVisits(String tutName) {i
//		String jpql="select t from Tutorial t where  t.tutorialName=:name";
//		Tutorial tutorial= manager.createQuery(jpql,Tutorial.class).setParameter("name", tutName).getSingleResult();
//		tutorial.setVisits(tutorial.getVisits()+1);
//		return "success";
//		
//	}

//	
//	@Override
//	public String addNewTutorial(Tutorial tutorial, int topicId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void deleteTutorial(String tutName) {
//		Query jpql="delete from tutorial t where t.tutorialName=:name";
		System.out.println("inside delete tutorial dao");
//		manager.createQuery("delete from tutorial t where t.tutorialName=:name").setParameter("name", tutName);
//		manager.remove(manager.createQuery("select t from tutorial t where t.tutorialName=:name").setParameter("name", tutName).getSingleResult());
		Tutorial t=manager.createQuery("select t from Tutorial t where t.tutorialName=:name",Tutorial.class).setParameter("name", tutName).getSingleResult();
		manager.remove(t);
//		EntityManager.remove(tutorial);
	}

	@Override
	public void addTutorialsByTopic(int topicId, Tutorial t) {
		System.out.println("inside add tutorial");
		Topic topic=manager.find(Topic.class, topicId);
	    t.setTopic(topic);
	    manager.persist(t);
	}

	@Override
	public void updatetutorial(int topicId, Tutorial t) {
		System.out.println("inside update tutorial");
		//Topic topic=manager.find(Topic.class, topicId);
		Tutorial tut=manager.createQuery("select t from Tutorial t where t.name=:nm",Tutorial.class).setParameter("name", t.getTutorialName()).getSingleResult();
	    manager.merge(tut);
		
	}

}
