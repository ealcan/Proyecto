package com.ecosocial.main.controller.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RewardsDto implements Serializable {

	private static final long serialVersionUID = -1750698987774687782L;

	private String description;

    private String name;

    private double pricePoints;
    
    //Getters y Setters

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePoints() {
		return pricePoints;
	}

	public void setPricePoints(double pricePoints) {
		this.pricePoints = pricePoints;
	}   
    
    
	
}
