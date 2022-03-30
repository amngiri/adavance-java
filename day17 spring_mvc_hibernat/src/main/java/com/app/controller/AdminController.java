package com.app.controller;

import java.time.LocalDate;

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
	@Autowired
	private ITopicService topicService;
	// dependency
	@Autowired
	private ITutorialService tutorialService;

	public AdminController() {
		System.out.println("in ctor of " + getClass());
	}

//	 add request handling method : to get all topics
	@GetMapping("/welcome")
	public String getAllTopics(Model map) {
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/admin/welcome";
	}
	@GetMapping("/tutorials")
	public String showTutorialsByTopic(@RequestParam int topicId,Model map) {
		map.addAttribute("tut_names", tutorialService.getTutorialsByTopic(topicId));
		return "/admin/tutorials";
	}
	
	@GetMapping("/delete_tutorial")
	public String delete_tutorial_from_topic(@RequestParam String tut_name,@RequestParam int topicId,Model map) {
		tutorialService.delete_Tutorial(tut_name);
		return "/admin/tutorials";
		
	}
	@GetMapping("/add_form")
	public String add_form_from_topic(@RequestParam int topicId,Model map) {
		System.out.println("in add tut add dtls");
         //http://localhost:9090/spring-mvc-boot/admin/delete_tutorial?tut_name=Spring%20Boot
//		tutorialService.add_Tutorial(tut_name);
		map.addAttribute("topic_list", topicService.getAllTopics());
//		tutorialService.addTutorialsByTopic(topicId);
		return "/admin/addform";//AVN : /WEB-INF/views/customer/tutorial_details.jsp
		
	}
	@GetMapping("/add_tutorial")
	public String add_tutorial_from_topic(@RequestParam int topicId,@RequestParam String name,@RequestParam String author,@RequestParam String date,String content,Model map) {
		System.out.println("in add tut add dtls");
         //http://localhost:9090/spring-mvc-boot/admin/delete_tutorial?tut_name=Spring%20Boot
//		tutorialService.add_Tutorial(tut_name);
//		map.addAttribute("topic_list", topicService.getAllTopics());
//		tutorialService.addTutorialsByTopic(topicId);
		Tutorial t=new Tutorial(name,author,LocalDate.parse(date),content);
		tutorialService.addTutorialsByTopic(topicId,t);
		return "/admin/tutorials";//AVN : /WEB-INF/views/customer/tutorial_details.jsp
		
	}
	@GetMapping("/update_form")
	public String update_form_from_topic(@RequestParam int topicId,Model map) {
		//System.out.println("in update tut dtls");
         //http://localhost:9090/spring-mvc-boot/admin/delete_tutorial?tut_name=Spring%20Boot
//		tutorialService.add_Tutorial(tut_name);
//		map.addAttribute("topic_list", topicService.getAllTopics());
//		tutorialService.addTutorialsByTopic(topicId);

//		tutorialService.updateTutorialsByTopic(topicId);
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/admin/updatetutorialform";//AVN : /WEB-INF/views/customer/tutorial_details.jsp
		
	}
	@GetMapping("/update_tutorial")
	public String update_tutorial_from_topic(@RequestParam int topicId,@RequestParam String name,@RequestParam String author,@RequestParam String date,String content,Model map) {
		System.out.println("in add tut add dtls");
         //http://localhost:9090/spring-mvc-boot/admin/delete_tutorial?tut_name=Spring%20Boot
//		tutorialService.add_Tutorial(tut_name);
//		map.addAttribute("topic_list", topicService.getAllTopics());
//		tutorialService.addTutorialsByTopic(topicId);
		Tutorial t=new Tutorial(name,author,LocalDate.parse(date),content);
		tutorialService.updateTutorialsByTopic(topicId,t);
		return "/admin/tutorials";//AVN : /WEB-INF/views/customer/tutorial_details.jsp
	}
}
