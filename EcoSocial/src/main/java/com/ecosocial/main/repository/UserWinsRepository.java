package com.ecosocial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.UserWinId;
import com.ecosocial.main.entities.UserWins;

public interface UserWinsRepository extends JpaRepository<UserWins, UserWinId> {

}
