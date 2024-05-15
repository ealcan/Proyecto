package com.ecosocial.main.controller.dto;

import java.io.Serializable;

import com.ecosocial.main.entities.Rewards;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class WinsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String name;
	
	private String description;
	
	private Boolean verified;
	
	private Double rewardsPoints;
	
	private String difficulty;
	
	private String image;
	
    public String getDifficulty() {
    	
        if (this.rewardsPoints <= 25) {
        	this.setDifficulty("Easy");
        }
        else if (this.rewardsPoints >= 25 && this.rewardsPoints <= 70){
        	this.setDifficulty("Medium");
        }
        else {
        	this.setDifficulty("Hard");
        }
        return difficulty;
    }
    
    public void setDifficulty(String difficulty) {
    	this.difficulty = difficulty;
    }

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

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Double getRewardsPoints() {
		return rewardsPoints;
	}

	public void setRewardsPoints(Double rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	



}
