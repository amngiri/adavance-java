package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
public HomeController() {
	System.out.println("in const of "+getClass().getName());
}

// add req handling method to forword 
@RequestMapping("/")
public String homePage() {
	return "/index";
}
}
