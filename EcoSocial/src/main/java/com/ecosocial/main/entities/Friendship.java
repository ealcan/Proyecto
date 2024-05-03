package com.ecosocial.main.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Friendship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "friends")
    private Set<User> users = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id_1")
	private User user1;
	
	@ManyToOne
	@JoinColumn(name = "user_id_2")
	private User user2;
}
