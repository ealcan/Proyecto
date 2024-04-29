package com.ecosocial.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_wins")
public class UserWins {

	@JsonIgnore
    @EmbeddedId
    private UserWinId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("winId")
    @JoinColumn(name = "wins_id")
    private Wins win;
    

    // Getters and setters
    

	public UserWinId getId() {
		return id;
	}

	public void setId(UserWinId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Wins getWin() {
		return win;
	}

	public void setWin(Wins win) {
		this.win = win;
	}

    
}

