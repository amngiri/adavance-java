package com.app.dao;

import java.util.List;

import com.app.pojos.Advertisement;

public interface IAdvertisementDao {
	List<Advertisement> getAllAdvertisement() ;
	
	String addAdvt(Advertisement a);
}
