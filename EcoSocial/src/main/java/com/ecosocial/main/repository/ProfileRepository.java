package com.ecosocial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
