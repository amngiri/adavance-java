package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IUserDao;
import com.app.pojos.User;
import com.app.pojos.UserRole;
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
			if (user.getRole().equals(UserRole.ADMIN)) 
				return "redirect:/admin/list_of_advt";
			return "redirect:/user/login";
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
	public String processAdmitForm(User u, HttpSession session) {
		System.out.println("in process form " + u);
		String message = userDao.registerUser(u);
		session.setAttribute("msg", message);
		return "redirect:/user/login";
	}
}
