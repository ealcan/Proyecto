package com.ecosocial.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.Rewards;

public interface RewardsRepository extends JpaRepository<Rewards, Integer> {
	Optional<Rewards> findById(Integer id);
}
