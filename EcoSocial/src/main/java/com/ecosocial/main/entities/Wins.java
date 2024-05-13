package com.ecosocial.main.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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


    @Column(name = "rewards_points")
    private double rewardsPoints;
    
    @Column(name = "image")
    private String image;

	@JsonIgnore
    @ManyToMany(mappedBy = "wins")
    private Set<User> users = new HashSet<>();

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

	public double getRewardsPoints() {
		return rewardsPoints;
	}

	public void setRewardsPoints(double rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}
	
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
    //Getters and Setters
    
    
}
