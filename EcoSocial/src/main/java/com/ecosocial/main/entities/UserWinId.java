package com.ecosocial.main.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class UserWinId implements Serializable {


	@Column(name = "user_id")
    private Integer userId;

    @Column(name = "win_id")
    private Integer winId;
    
    // Constructores, getters y setters

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getWinId() {
		return winId;
	}

	public void setWinId(Integer winId) {
		this.winId = winId;
	}

    
    
}
