package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ITopicService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//dependency 
	@Autowired
	private ITopicService topicService;
	public CustomerController() {
		System.out.println("in ctor of "+getClass());
	}
	//add request handling method : to get all topics
	@GetMapping("/topics")
	public String getAllTopics(Model map)
	{
		System.out.println("in get all topics ");
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/customer/topics";//AVN : /WEB-INF/views/customer/topics.jsp		
	}

}
