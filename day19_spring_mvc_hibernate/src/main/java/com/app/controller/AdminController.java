package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Tutorial;
import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency : Topic service i/f
	@Autowired
	private ITopicService topicService;
	@Autowired
	private ITutorialService tutorialService;

	public AdminController() {
		System.out.println("in ctor of " + getClass());
	}

	// add request handling method to forward the clnt to admin welcome page
	@GetMapping("/welcome")
	public String showAdminWelcomePage(Model map) {
		System.out.println("in show admin welcome page");
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/admin/welcome";// AVN : /WEB-INF/view/admin/welcome.jsp
	}

	// http://localhost:9090/spring-mvc-boot/admin/tutorial_list?topicDetails=1%3AServlets
	// add request handling method to forward the clnt to tut list page
	@GetMapping("/tutorial_list")
	public String showTutsBySelectedTopic(@RequestParam String topicDetails, Model map, HttpSession session) {
		System.out.println("in show tuts by topic id " + topicDetails);
		int topicId = Integer.parseInt(topicDetails.split(":")[0]);
		String topicName = topicDetails.split(":")[1];
		System.out.println(topicId + " " + topicName);
		// store topic details under sesison scope
		session.setAttribute("selected_topic_id", topicId);
		session.setAttribute("selected_topic_name", topicName);
		// get list of tutorial undet selected topic id
		map.addAttribute("tut_list", tutorialService.getTutorialsByTopic(topicId));
		return "/admin/tutorial_list";
	}

	// add new method , to show the form for adding a new tutorial
	@GetMapping("/add_tutorial")
	public String showAddTutorialForm(@RequestParam int topicId,Tutorial tut) // can be alternatively taken from HttpSession
	{
		System.out.println("in show add tut form " + topicId);
		return "/admin/add_tutorial";
	}
	// add new method , to process the form : post

}
