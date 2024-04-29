package com.ecosocial.main.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_rewards")
public class UserRewards {

    @EmbeddedId
    private UserRewardId id;

    @ManyToOne
    @MapsId("user_id")
    private User user;

    @ManyToOne
    @MapsId("rewards_id")
    private Rewards reward;
    

    // Getters and setters

	public UserRewardId getId() {
		return id;
	}

	public void setId(UserRewardId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Rewards getReward() {
		return reward;
	}

	public void setReward(Rewards reward) {
		this.reward = reward;
	}

    
    
}

