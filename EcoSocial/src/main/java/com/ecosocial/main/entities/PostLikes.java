package com.ecosocial.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_likes")
public class PostLikes {

	@JsonIgnore
    @EmbeddedId
    private PostLikesId id;
	
    @ManyToOne
    @JoinColumn(name = "post_id", insertable=false, updatable=false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_id", insertable=false, updatable=false)
    private Profile profile;
    

    // Constructor, getters y setters

	public PostLikesId getId() {
		return id;
	}

	public void setId(PostLikesId id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

    
    
}