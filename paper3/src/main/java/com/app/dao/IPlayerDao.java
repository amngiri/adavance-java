package com.app.dao;

import java.util.List;

import com.app.pojos.Player;

public interface IPlayerDao {
	List<Player> getAllPlayer();
	
	Player bestBatsman(int stats, String role);
	
	Player bestBowler(int stats, String role);
	
	String removePlayer(int id);
	
	String addPlayer(Player player);
}
