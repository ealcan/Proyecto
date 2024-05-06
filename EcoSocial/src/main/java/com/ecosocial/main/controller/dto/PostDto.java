package com.ecosocial.main.controller.dto;

import java.time.LocalDateTime;

public class PostDto {
	private String title;
	private String content;
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
	
	
}
