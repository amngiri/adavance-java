//package com.app.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.app.pojos.FoodType;
//
//@Repository
//@Transactional
//public class TopicDaoImpl implements ITopicDao {
//	@Autowired //OR can use JPA annotation : @PersistenceContext
//	private EntityManager manager;
//
//	@Override
//	public List<FoodType> getAllTopics() {
//		String jpql="select t from Topic t";
//		return manager.createQuery(jpql, FoodType.class).getResultList();
//	}//method rets : session closing
//
//}
