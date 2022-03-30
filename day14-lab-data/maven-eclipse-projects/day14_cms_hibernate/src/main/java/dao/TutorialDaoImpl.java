package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import pojos.Tutorial;
import pojos.User;

public class TutorialDaoImpl implements ITutorialDao {

	@Override
	public List<String> getTutorialsByTopicId(int topicId) {
		List<String> names = null;
		String jpql = "select t.tutorialName from Tutorial t where t.topic.id=:id";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("id", topicId).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) {
		Tutorial tutorial = null;
		String jpql = "select t from Tutorial t where t.tutorialName=:nm";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tutorial = session.createQuery(jpql, Tutorial.class).setParameter("nm", tutName).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return tutorial;
	}

	@Override
	public String updateVisits(String tutName) {
		String msg="cant update visits";
		Tutorial tutorial = null;
		String jpql = "select t from Tutorial t where t.tutorialName=:nm";
		// get session from SF
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tutorial = session.createQuery(jpql, Tutorial.class).setParameter("nm", tutName).getSingleResult();
			tutorial.setVisits(tutorial.getVisits() + 1);
			tx.commit();
			msg="updated visits";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String addNewTutorial(Tutorial tutorial, int topicId) {
		String msg="cant add new tutorial in the topic";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Topic t=session.get(Topic.class, topicId);
			tutorial.setTopic(t);
             session.persist(tutorial);
             tx.commit();
             msg="added new tutorial in the topic";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return msg;

	}

}
