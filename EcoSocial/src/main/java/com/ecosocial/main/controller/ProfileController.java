package com.ecosocial.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.repository.ProfileRepository;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	 @Autowired
	    private ProfileRepository profileRepository;

	    // Obtener todos los usuarios
	    @GetMapping
	    public ResponseEntity<List<Profile>> getAllProfiles() {
	        List<Profile> profiles = profileRepository.findAll();
	        return new ResponseEntity<>(profiles, HttpStatus.OK);
	    }
}
