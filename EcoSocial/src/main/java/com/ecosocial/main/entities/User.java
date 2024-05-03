package com.ecosocial.main.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import com.ecosocial.main.services.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "points")
    private double points;

    @ManyToMany
    @JoinTable(
        name = "user_wins",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "wins_id")
    )
    private Set<Wins> wins = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "user_reward",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "reward_id")
    )
    private Set<Rewards> rewards = new HashSet<>();
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "user_friends",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<Friendship> friends = new HashSet<>();    
    
    @OneToOne
    @JoinColumn(name = "id")
    private Profile profile;
    // Getters y setters
    

	public Profile getProfile() {
		return profile;
	}



	public void setProfile(Profile profile) {
		this.profile = profile;
	}



	public int getId() {
		return id;
	}

	
	
	public Set<Rewards> getRewards() {
		return rewards;
	}


	public void setRewards(Set<Rewards> rewards) {
		this.rewards = rewards;
	}

	
	public Set<Wins> getWins() {
		return wins;
	}


	public void setWins(Set<Wins> win) {
		this.wins = win;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
    public Set<Wins> getVerifiedWins() {
        UserWinsService userWinService = new UserWinsService();
        return userWinService.getVerifiedWinsForUser(this);
    }

    public Set<Wins> getUnverifiedWins() {
        UserWinsService userWinService = new UserWinsService();
        return userWinService.getUnVerifiedWinsForUser(this);
    }



	
}

