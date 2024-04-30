package com.ecosocial.main.controller.dto;

public class UserRewardsDto {
	private String name;
	private String description;
	private double pricePoints;
	
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
	public double getPricePoints() {
		return pricePoints;
	}
	public void setPricePoints(double pricePoints) {
		this.pricePoints = pricePoints;
	}
	
	
}
