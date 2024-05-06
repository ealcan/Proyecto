package com.ecosocial.main.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("rewards")
public class RewardsPost extends Post {
	
     @ManyToOne
	 @JoinColumn(name = "reward_id")
	 private Rewards reward;
	
	 private String rewardName;

	 private String rewardDescription;

	 // Getters y setters para la relación con Reward
	 public Rewards getReward() {
	     return reward;
	 }

	 public void setReward(Rewards reward) {
	     this.reward = reward;
	 }
	 
	 
	 public String getRewardName() {
	     return rewardName; // Utiliza el título heredado de la clase base Post
	 }

	 public void setRewardName(Rewards reward) {
	     super.setTitle(reward.getName()); // Establece el título heredado de la clase base Post
	 }

	 // Getter y setter para rewardDescription
	 public String getRewardDescription() {
	     return rewardDescription;
	 }

	 public void setRewardDescription(Rewards reward) {
	        super.setContent(reward.getDescription());
	 }

    
}