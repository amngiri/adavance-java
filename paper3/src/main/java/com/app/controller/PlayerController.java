package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IPlayerDao;
import com.app.pojos.Player;

@Controller
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private IPlayerDao playerDao;

	@RequestMapping("/all_players")
	public String getAllPlayers(Model map) {
		map.addAttribute("list", playerDao.getAllPlayer());
		return "/player/all_players";
	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam int id) {
		playerDao.removePlayer(id);
		return "redirect:/player/all_players";
	}

	@GetMapping("/addplayer")
	public String showNewVendorForm(Player p) {
		return "/player/addplayer";
	}
	
	@PostMapping("/addplayer")
	public String processNewVendorForm(Player p) {
		playerDao.addPlayer(p);
		return "redirect:/player/all_players";
	}
}
