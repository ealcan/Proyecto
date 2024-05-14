package com.ecosocial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.PostLikesId;
import com.ecosocial.main.entities.PostLikes;

public interface PostLikesRepository extends JpaRepository<PostLikes, PostLikesId> {

}
