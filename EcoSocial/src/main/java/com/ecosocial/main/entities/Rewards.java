package com.ecosocial.main.entities;

import java.util.HashSet;
import java.util.List;
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
@Table(name = "rewards")
public class Rewards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price_points")
    private double pricePoints;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "rewards")
    private Set<User> users = new HashSet<>();
	

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePoints() {
		return pricePoints;
	}

	public void setPricePoints(double pricePoints) {
		this.pricePoints = pricePoints;
	}

    // Getters y setters
    
    
}
