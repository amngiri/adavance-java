package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserControlller {
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserDao userDao;

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
			Model modelMap, HttpSession session) {

		System.out.println("in process login form....... " + email + " " + pwd);
		try {
			User user = userService.validateUser(email, pwd);
			session.setAttribute("user_details", user);
			return "redirect:/user/show";
		} catch (RuntimeException e) {
			System.out.println("err in process login form");
			modelMap.addAttribute("message", "Invalid Login, Please retry..");
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
		userDao.registerUser(u);
		return "redirect:/user/login";
	}
	
	@GetMapping("/show") 
	public String showform() {
		return "/user/show";
	}
	
	@GetMapping("/forget") 
	public String forgetForm( ) {
		return "/user/forget";
	}
	
	@PostMapping("/forget") 
	public String forgetProcess(@RequestParam String name, @RequestParam String email, RedirectAttributes map) {
		String password = userDao.getPassword(name, email);
		map.addFlashAttribute("password", password);
		return "redirect:/user/login";
	}
}
