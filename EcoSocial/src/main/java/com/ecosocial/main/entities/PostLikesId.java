package com.ecosocial.main.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PostLikesId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer profile_id;
    private Integer post_id;
    
    // Getters and setters

	public Integer getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(Integer profile_id) {
		this.profile_id = profile_id;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
    
    

}
