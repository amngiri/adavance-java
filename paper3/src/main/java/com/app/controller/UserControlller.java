package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserControlller {
	@Autowired
	private IUserService userService;

	public UserControlller() {
		System.out.println("in const " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam(name = "password") String pwd,
			HttpSession session) {
		System.out.println("in process login form....... " + email + " " + pwd);
		try {
			User user = userService.validateUser(email, pwd);
			session.setAttribute("user_details", user);
			return "redirect:/player/all_players";

		} catch (RuntimeException e) {
			System.out.println("err in process login form");
			session.setAttribute("message", "Invalid Login, Please retry..");
			return "redirect:/user/login";
		}

	}
}
