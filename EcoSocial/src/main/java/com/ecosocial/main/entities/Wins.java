package com.ecosocial.main.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wins")
public class Wins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "rewards_points")
    private double rewardsPoints;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "wins")
    private List<User> users = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public double getRewardsPoints() {
		return rewardsPoints;
	}

	public void setRewardsPoints(double rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
	    this.users.addAll(users);
	}


    //Getters and Setters
    
    
}
