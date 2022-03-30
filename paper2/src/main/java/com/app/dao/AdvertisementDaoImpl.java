package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Advertisement;


@Repository
@Transactional
public class AdvertisementDaoImpl implements IAdvertisementDao{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Advertisement> getAllAdvertisement() {
		return sf.getCurrentSession().createQuery("select a from Advertisement a",Advertisement.class).getResultList();
	}

	@Override
	public String addAdvt(Advertisement a) {
		int statusCode = (Integer) sf.getCurrentSession().save(a);
		if (statusCode > 0)
			return "Product registered";
		return "Product registration Failed";
		
	}

}
