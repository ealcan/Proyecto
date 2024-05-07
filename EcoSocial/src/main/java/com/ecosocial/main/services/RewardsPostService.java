package com.ecosocial.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.RewardsPost;
import com.ecosocial.main.exception.ResourceNotFoundException;
import com.ecosocial.main.repository.RewardPostRepository;

@Service
public class RewardsPostService {

	private RewardPostRepository rewardPostRepository;

    @Autowired
    public void RewardPostService(RewardPostRepository rewardPostRepository) {
        this.rewardPostRepository = rewardPostRepository;
    }

    
    public List<RewardsPost> getAllRewardPosts() {
        return rewardPostRepository.findAll();
    }

    public Optional<RewardsPost> getRewardPostById(Integer id) {
        return rewardPostRepository.findById(id);
    }

    public RewardsPost createRewardPost(RewardsPost rewardPost) {
        return rewardPostRepository.save(rewardPost);
    }

    public RewardsPost updateRewardPost(Integer id, RewardsPost rewardPost) {
        if (rewardPostRepository.existsById(id)) {
            rewardPost.setId(id);
            return rewardPostRepository.save(rewardPost);
        } else {
            throw new ResourceNotFoundException("Reward Post", "id", id);
        }
    }

    public void deleteRewardPost(Integer id) {
        rewardPostRepository.deleteById(id);
    }
}