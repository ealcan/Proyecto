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

import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.entities.WinsPost;
import com.ecosocial.main.repository.ProfileRepository;
import com.ecosocial.main.repository.WinsRepository;
import com.ecosocial.main.services.WinsPostService;

@RestController
@RequestMapping("/winsposts")
public class WinsPostController {
	
	@Autowired
	private WinsPostService winsPostService;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private WinsRepository winsRepository;
	
	@GetMapping
    public ResponseEntity<List<WinsPost>> getAllRewardPosts() {
        List<WinsPost> winsPosts = winsPostService.getAllWinsPosts();
        return new ResponseEntity<>(winsPosts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WinsPost> getRewardPostById(@PathVariable Integer id) {
        Optional<WinsPost> winsPost = winsPostService.getWinsPostById(id);
        return winsPost.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{profileId}/{winsId}")
    public ResponseEntity<WinsPost> createRewardsPost(@PathVariable Integer profileId, @PathVariable Integer winsId) {
        // Buscar el perfil y el Reward correspondientes a los IDs proporcionados
        Profile profile = profileRepository.findById(profileId).orElse(null);
        Wins win = winsRepository.findById(winsId).orElse(null);

        // Crear un nuevo RewardsPost con el Reward
        WinsPost winsPost = new WinsPost(win);
        
        // Asignar el perfil al RewardsPost
        winsPost.setProfile(profile);

        // Guardar el RewardsPost
        WinsPost createdWinsPost = winsPostService.createWinsPost(winsPost);

        return new ResponseEntity<>(createdWinsPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WinsPost> updateRewardPost(@PathVariable Integer id, @RequestBody WinsPost winsPost) {
    	WinsPost updatedWinsPost = winsPostService.updateWinsPost(id, winsPost);
        return new ResponseEntity<>(updatedWinsPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRewardPost(@PathVariable Integer id) {
        winsPostService.deleteRewardPost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
