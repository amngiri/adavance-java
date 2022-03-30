package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of " + getClass());
	}
	@PostConstruct
	public void init123()
	{
		System.out.println("in init "+getClass());
	}
	//add request handling method to send welcome mesg
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("in say hello");
		return "/welcome";
	}
	

}
