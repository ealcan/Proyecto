package com.ecosocial.main.controller.dto;

import com.ecosocial.main.entities.Rewards;

public class RewardsPostDto {
	
	 private Rewards reward;
		
	 private String rewardName;

	 private String rewardDescription;
	 
	 //Getters y Setters

	public Rewards getReward() {
		return reward;
	}

	public void setReward(Rewards reward) {
		this.reward = reward;
	}

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getRewardDescription() {
		return rewardDescription;
	}

	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}
	 
	 
}
