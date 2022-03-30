package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;

import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
//	@Autowired
//	private ITopicService topicService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping("/login")
	public String showLoginFrom() {
		System.out.println("in show login form");
		return "/user/login";
	}

	@PostMapping("/login") // @RequestMapping + method=POST
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session) {
		System.out.println("in process login form " + email + " " + password + " " + map);
		try {

			User user = userService.authenticateUser(email, password);

			session.setAttribute("user_details", user);

			return "redirect:/customer/topics";// UserController sends to D.S : redirect view name

		} catch (RuntimeException e) {
			System.out.println("err in class " + getClass() + "in  process login form " + e);

			map.addAttribute("message", "Invalid Login , Please retry.....");
			return "/user/login";
		}

	}

	@GetMapping("/register")
	public String showAdmitForm(User u) {
		return "/user/register";
	}

	@PostMapping("/register")
	public String processAdmitForm(User u) {
		System.out.println("in process form " + u);
		userService.registerUser(u);
		return "redirect:/user/login";
	}

	// add method to logout

	@GetMapping("/logout")
	public String userlogout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("in logout");
		// copy sessionScope attr in model so that we can remember client name
		map.addAttribute("user_dtld", session.getAttribute("user_details"));

		// discard session
		session.invalidate();
		// autoredirect to idex page automatically
		resp.setHeader("refresh", "5;url=" + request.getContextPath());
		return null;
	}

}
