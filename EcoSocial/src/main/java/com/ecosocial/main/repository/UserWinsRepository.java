package com.ecosocial.main.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.UserWinId;
import com.ecosocial.main.entities.UserWins;
import com.ecosocial.main.entities.Wins;

public interface UserWinsRepository extends JpaRepository<UserWins, UserWinId> {
	    Set<UserWins> findByVerifiedTrue();
	    Set<UserWins> findByUserAndVerifiedIsTrue(User user);
	    Set<UserWins> findByUserAndVerifiedIsFalse(User user);
	    UserWins findByUserAndWin(User user, Wins win);
	}


