package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dao.ITopicDao;

@Controller
public class HomePageController {
	//in case you skip the service layee , what will be be the dependency  ?
	@Autowired
	private ITopicDao topicDao;
	
	public HomePageController() {
		System.out.println("in ctor of "+getClass());
	}
	@GetMapping("/")
	public String showHomePage(Model map) {
		System.out.println("in show home page");
		//invoke dao's method
		map.addAttribute("topic_list", topicDao.getAllTopics());
		return "/index";//AVN : /WEB-INF/views/index.jsp
	}
}
