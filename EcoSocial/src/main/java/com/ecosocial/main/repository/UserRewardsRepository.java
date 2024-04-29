package com.ecosocial.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.*;

public interface UserRewardsRepository extends JpaRepository<UserRewards, UserRewardId> {
	
}
