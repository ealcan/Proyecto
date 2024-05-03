package com.ecosocial.main.controller.dto;

import java.util.Set;

import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.Wins;

import lombok.Data;

@Data
public class ProfileDto {

	private String username;
	private String name;
	private double points;
	private String lastName;
	private byte[] profileImage;
	private Set<Rewards> rewards;
	private Set<Wins> wins;
}
