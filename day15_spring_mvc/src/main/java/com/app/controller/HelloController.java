package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //MANDATORY cls level annotation to tell SC that the following class will contain req handling logic
//i.e it's request handling controller ,request handler
//Singleton n Eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass());
	}
	@PostConstruct
	public void myInit()
	{
		System.out.println("in init of "+getClass());
	}
	//add request handling method to handle /hello request
	@RequestMapping("/hello")
	//Map : key : /hello 
	//value : com.app.controller.HelloController.sayHello
	//who : SC , when @ app dep time
	public String sayHello()
	{
		System.out.println("in sayHello");
		return "/welcome";
	}
	

}
