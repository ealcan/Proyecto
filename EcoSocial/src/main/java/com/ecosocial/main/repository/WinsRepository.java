package com.ecosocial.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecosocial.main.controller.dto.WinsDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.Wins;

public interface WinsRepository extends JpaRepository<Wins, Integer> {
	Optional<Wins> findById(Integer id);
	List<Wins> findByUsersId(Integer id);
	List<Wins> findByUsersUsername(String username);
	WinsDto findWinById(Integer id);
	
	boolean existsByName(String name);

}
