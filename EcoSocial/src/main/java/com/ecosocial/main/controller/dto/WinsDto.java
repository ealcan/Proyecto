package com.ecosocial.main.controller.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class WinsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private Boolean verified;
	
	private Double rewardsPoints;

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
	
	
	



}
