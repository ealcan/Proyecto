package com.ecosocial.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("rewards")
public class RewardsPost extends Post {
	
	 @JsonIgnore
     @ManyToOne
	 @JoinColumn(name = "reward_id")
	 private Rewards reward;
	 
	public RewardsPost() {
			// Puedes inicializar valores predeterminados aquí si es necesario
	}
	 
	 // Constructor
	 public RewardsPost(Rewards reward) {
		 this.reward = reward;
		 super.setTitle(reward.getName());
		 super.setContent(reward.getDescription());
	 }

	 // Getters y setters para la relación con Reward
	 public Rewards getReward() {
	     return reward;
	 }

	 public void setReward(Rewards reward) {
	     this.reward = reward;
	 }
	
}