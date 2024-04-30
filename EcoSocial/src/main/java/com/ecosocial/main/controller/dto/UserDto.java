package com.ecosocial.main.controller.dto;

import java.util.Set;

import com.ecosocial.main.entities.Rewards;

import lombok.Data;

@Data
public class UserDto {

	private String username;	
	private String password;
	private String email;
	private double points;
	private Set<Rewards> rewards;
}
