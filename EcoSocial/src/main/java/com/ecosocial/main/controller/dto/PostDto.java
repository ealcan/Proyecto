package com.ecosocial.main.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.ecosocial.main.entities.Profile;

public class PostDto {
	private String title;
	private String content;
	private int likes;
	private LocalDateTime publishedAt;
	
	
	//Getters y Setters
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}
	public int getLikes() {
		return likes;
	}
	public int setLikes(Set<Profile> profiles) {
		int like_list = 0;
		
		for (Profile profile: profiles) {
			like_list += 1;
			
		}
		return like_list;
	}
	
	
	
	
}
