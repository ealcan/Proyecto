package com.ecosocial.main.controller.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RewardsDto implements Serializable {

	private static final long serialVersionUID = -1750698987774687782L;

	private String description;

    private String name;

    private double pricePoints;   
    
	
}
