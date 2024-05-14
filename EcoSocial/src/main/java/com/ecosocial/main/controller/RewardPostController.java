package com.ecosocial.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.RewardsPost;
import com.ecosocial.main.repository.PostRepository;
import com.ecosocial.main.repository.ProfileRepository;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.services.ProfileService;
import com.ecosocial.main.services.RewardsPostService;
import com.ecosocial.main.services.RewardsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rewardposts")
public class RewardPostController {

    private final RewardsPostService rewardPostService;

    @Autowired
    public RewardPostController(RewardsPostService rewardPostService) {
        this.rewardPostService = rewardPostService;
    }
    
    @Autowired
    private ProfileRepository profileRepository;
    
    @Autowired
    private RewardsRepository rewardRepository;


    @GetMapping
    public ResponseEntity<List<RewardsPost>> getAllRewardPosts() {
        List<RewardsPost> rewardPosts = rewardPostService.getAllRewardPosts();
        return new ResponseEntity<>(rewardPosts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RewardsPost> getRewardPostById(@PathVariable Integer id) {
        Optional<RewardsPost> rewardPost = rewardPostService.getRewardPostById(id);
        return rewardPost.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{profileId}/{rewardId}")
    public ResponseEntity<RewardsPost> createRewardsPost(@PathVariable Integer profileId, @PathVariable Integer rewardId) {
        // Buscar el perfil y el Reward correspondientes a los IDs proporcionados
        Profile profile = profileRepository.findById(profileId).orElse(null);
        Rewards reward = rewardRepository.findById(rewardId).orElse(null);

        // Crear un nuevo RewardsPost con el Reward
        RewardsPost rewardsPost = new RewardsPost(reward);
        
        // Asignar el perfil al RewardsPost
        rewardsPost.setProfile(profile);

        // Guardar el RewardsPost
        RewardsPost createdRewardsPost = rewardPostService.createRewardPost(rewardsPost);

        return new ResponseEntity<>(createdRewardsPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RewardsPost> updateRewardPost(@PathVariable Integer id, @RequestBody RewardsPost rewardPost) {
        RewardsPost updatedRewardPost = rewardPostService.updateRewardPost(id, rewardPost);
        return new ResponseEntity<>(updatedRewardPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRewardPost(@PathVariable Integer id) {
        rewardPostService.deleteRewardPost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

