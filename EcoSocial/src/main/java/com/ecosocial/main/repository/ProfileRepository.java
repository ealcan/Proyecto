package com.ecosocial.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.controller.dto.ProfileDto;
import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.entities.User;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	Profile findByUser(User user);
	Optional<Profile> findById(int id);
}
