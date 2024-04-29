package com.ecosocial.main.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserRewardId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer user_id;
    private Integer rewards_id;
    
    // Getters and setters
    
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getRewards_id() {
		return rewards_id;
	}
	public void setRewards_id(Integer rewards_id) {
		this.rewards_id = rewards_id;
	}


    
    
}