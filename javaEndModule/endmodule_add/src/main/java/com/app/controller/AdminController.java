package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IAdvertisementDao;
import com.app.dao.IUserDao;
import com.app.pojos.Advertisement;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdvertisementDao advtDao;
	
	@Autowired
	private IUserDao user;
	@GetMapping("/list_of_advt")
	public String getAllAdvertisement(Model map, HttpSession session) {
		System.out.println("lis = "+advtDao.getAllAdvertisement());
		session.setAttribute("admin_email", user);
		map.addAttribute("advt_list", advtDao.getAllAdvertisement());
		return "/admin/list_of_advt";
	}

	@GetMapping("/addproduct")
	public String addProduct(Advertisement a) {
		return "/admin/addproduct";
	}
	
	@PostMapping("/addproduct")
	public String addProductProcess(Advertisement a, HttpSession session) {
		
		session.setAttribute("status", advtDao.addAdvt(a));
		return "redirect:/admin/list_of_advt";
	}
}
