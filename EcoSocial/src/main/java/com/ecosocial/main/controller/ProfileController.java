package com.ecosocial.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosocial.main.controller.dto.ProfileDto;
import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.repository.ProfileRepository;
import com.ecosocial.main.services.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	 @Autowired
	    private ProfileRepository profileRepository;
	 @Autowired
	 private ProfileService profileService;

	    // Obtener todos los perfiles
	    @GetMapping
	    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
	        List<ProfileDto> profiles = profileService.getAllProfiles();
	        return new ResponseEntity<>(profiles, HttpStatus.OK);
	    }
	    
	    // Obtener el ranking de los amigos según el ID de un usuario
	    @GetMapping("ranking-friends/{id}")
	    public ResponseEntity<List<ProfileDto>> getRankingFriends(@PathVariable("id") Integer profileId) {
	        List<ProfileDto> profiles = profileService.getRanking(profileId);
	        return new ResponseEntity<>(profiles, HttpStatus.OK);
	    }
	    
	    // Obtener un perfil por su ID
	    /*@GetMapping("/{id}")
	    public ResponseEntity<Profile> getProfileById(@PathVariable("id") int id) {
	        Optional<Profile> profileOptional = profileRepository.findById(id);
	        if (profileOptional.isPresent()) {
	            return new ResponseEntity<>(profileOptional.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }*/
	    
	    //Obtener un perfil mediante su ID
	    @GetMapping("/{id}")
	    public ProfileDto getProfile (@PathVariable("id") Integer profileId) {
	    	return profileService.getProfileById(profileId);
	    }
	    
	    //Obtener los perfiles de los amigos de un perfil mediante su ID
	    @GetMapping("/friends/{id}")
	    public ResponseEntity<List<ProfileDto>> getAllFriendsByProfile(@PathVariable("id") Integer profileId) {
	        List<ProfileDto> profiles = profileService.getFriendshipByUser(profileId);
	        return new ResponseEntity<>(profiles, HttpStatus.OK);
	    }

	    // Crear un nuevo perfil
	    @PostMapping("/")
	    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
	        Profile createdProfile = profileRepository.save(profile);
	        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
	    }

	    // Actualizar un perfil existente
	    @PutMapping("/{id}")
	    public ResponseEntity<Profile> updateProfile(@PathVariable("id") int id, @RequestBody Profile profile) {
	        Optional<Profile> profileOptional = profileRepository.findById(id);
	        if (profileOptional.isPresent()) {
	            profile.setId(id); // Aseguramos que el ID sea el correcto
	            Profile updatedUser = profileRepository.save(profile);
	            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Eliminar un perfil por su ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProfile(@PathVariable("id") int id) {
	        Optional<Profile> profileOptional = profileRepository.findById(id);
	        if (profileOptional.isPresent()) {
	            profileRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
