package com.ecosocial.main.controller.dto;

import java.util.Set;

import com.ecosocial.main.entities.Post;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.Wins;

import lombok.Data;

@Data
public class ProfileDto {
	private String name;
	private String lastName;
	private String username;
	private double points;
	private Set<Wins> wins;
	private Set<Rewards> rewards;
	private Set<Post> posts;
	
    public double getRankingPoints() {
    	double totalpoints = 0;
    	
        for (Rewards reward : rewards) {

        	totalpoints += reward.getPricePoints();
        }
        return points + totalpoints;
    }

	
	
	public Set<Wins> getWins() {
		return wins;
	}
	public void setWins(Set<Wins> wins) {
		this.wins = wins;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Rewards> getRewards() {
		return rewards;
	}
	public void setRewards(Set<Rewards> rewards) {
		this.rewards = rewards;
	}

	public Set<Post> getPosts() {
		return posts;
	}


	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}