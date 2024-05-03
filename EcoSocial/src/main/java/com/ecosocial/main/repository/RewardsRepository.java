package com.ecosocial.main.repository;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecosocial.main.entities.Rewards;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer> {
	
	//Haciendo la query manual
	/*@Query("SELECT r FROM Rewards r JOIN r.users u WHERE u.id = :id ")
	List<Rewards> findRewardByUserId(Integer id);*/
	
	//Hace la query de manera inteligente gracias al nombre
	List<Rewards> findByUsersId(Integer id);
	List<Rewards> findByUsersUsername(String username);
	
	boolean existsByName(String name);
}
