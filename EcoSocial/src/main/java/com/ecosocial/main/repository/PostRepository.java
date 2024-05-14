package com.ecosocial.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecosocial.main.entities.Post;
import com.ecosocial.main.entities.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
//	Optional<Post> findById(Integer PostId);
//	boolean existsById(Integer PostId);
	List<Post> findPostById(Integer id);
}
