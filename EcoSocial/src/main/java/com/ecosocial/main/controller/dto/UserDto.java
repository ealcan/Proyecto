package com.ecosocial.main.controller.dto;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.services.UserWinsService;
import com.ecosocial.main.services.WinService;

import lombok.Data;

@Data
public class UserDto {

	private String username;	
	private String email;
	private double points;
	
	private Set<Rewards> rewards;
	private Set<Wins> wins;
	
    public double getRankingPoints() {
    	double totalpoints = 0;
    	
        for (Rewards reward : rewards) {

        	totalpoints += reward.getPricePoints();
        }
        return points + totalpoints;
    }
	//Getters y Setters
	
	@Autowired
	UserWinsService userWinService;
	
	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public Set<Rewards> getRewards() {
		return rewards;
	}
	public void setRewards(Set<Rewards> rewards) {
		this.rewards = rewards;
	}
	
	public Set<Wins> getWins() {
		return wins;
	}
	public void setWins(Set<Wins> wins) {
		this.wins = wins;
	}
	
	
}
