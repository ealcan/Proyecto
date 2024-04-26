package com.ecosocial.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByUsername(String username);
	Optional<User> findById(Integer id);
}

