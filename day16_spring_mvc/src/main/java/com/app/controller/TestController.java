package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // MANDATORY
@RequestMapping("/test") // Optional BUT reco cls level annotation : to separate all testing related
							// actions under TestController
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method : MANDATORY method level anno :
	@GetMapping("/test1")
	// Entry in H.M (Handler Mapping bean)
	// key : /test/test1 +method=GET
	// value : com.app.controller.TestController.testModelAndView
	public ModelAndView testModelAndView() {
		System.out.println("in test M n V");
		// API of o.s.w.s. ModelAndView(String logicalViewName,String
		// modelAttributeName,Object modelAttributeValue)
		return new ModelAndView("/test/test1", "server_timestamp", LocalDateTime.now());
		// AVN resolved by V.R bean : /WEB-INF/views/test/test1.jsp
	}

	// add req handling method to understand Model Map
	@GetMapping("/test2")
	public String testModelMap(Model map) // SC creates an empty Model map n injects it in the method
	{
		System.out.println("in test model map " + map);// {}
		// add 2 attributes under Model map
		// o.s.ui.Model --i/f
		// public Model addAttrbute(String modelAttrName,Object modelAttrbuteValue)
		map.addAttribute("server_timestamp", LocalDateTime.now()).addAttribute("number_list",
				Arrays.asList(10, 20, 30, 40));
		System.out.println("in test model map again  " + map);//{....}
		return "/test/test1";// Handler rets explicitly : LVN : /test/tes1
		//What's implicitly sent ? : LVN + map of model attrs
	//	AVN : /WEB-INF/views/test/test1.jsp
	}
}
