package com.ecosocial.main.controller.dto;

public class UserWinsDto {
	private String name;
    private String description;
    private double rewardsPoints;
    
    //Getters y Setters
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRewardsPoints() {
		return rewardsPoints;
	}
	public void setRewardsPoints(double rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}
    
    
}
