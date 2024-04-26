package com.ecosocial.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.Wins;

public interface WinsRepository extends JpaRepository<Wins, Integer> {
	Optional<Wins> findById(Integer id);
}
