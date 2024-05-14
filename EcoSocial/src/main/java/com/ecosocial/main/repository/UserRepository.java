package com.ecosocial.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecosocial.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByUsername(String username);
	Optional<User> findById(Integer id);
	List<User> findUserById(Integer id);
	Optional<User> findByUsername(String username);
	boolean existsByEmail(String email);
	List<User> findUserByUsername(String username);
	
	
//	@Query("SELECT DISTINCT u FROM User u " +
//	           "JOIN FETCH u.userWins uw " +
//	           "JOIN FETCH uw.win w " +
//	           "WHERE u.id = :userId AND w.verified = true")
//     List<User> findUsersWithVerifiedWins(@Param("userId") Integer userId);
}

