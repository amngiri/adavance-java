package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "players")
public class Player extends BaseEntity {
	
	// player_id , player_name, team_name, 
	//player_role (batsman, bowler) (according to role add runs and wickets),match played
	@Column(name = "player_name" , length = 20)
	private String playerName;
	@Column(name = "team_name" , length = 20)
	private String teamName;
	@Column( length = 10)
	private String role;
	private int stats;
	private int matches;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStats() {
		return stats;
	}
	public void setStats(int stats) {
		this.stats = stats;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public Player(String playerName, String teamName, String role, int stats, int matches) {
		super();
		this.playerName = playerName;
		this.teamName = teamName;
		this.role = role;
		this.stats = stats;
		this.matches = matches;
	}
	
	public Player() {
		
	}
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", teamName=" + teamName + ", role=" + role + ", stats=" + stats
				+ ", matches=" + matches + "]";
	}
	
	
	

}
