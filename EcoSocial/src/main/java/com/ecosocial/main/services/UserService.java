package com.ecosocial.main.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RewardsRepository rewardsRepository;

    public void assignWin(User user, Wins win) {
        user.setPoints(user.getPoints() - win.getRewardsPoints());
        user.setWins(win);
        userRepository.save(user);
    }

    public void assignReward(User user, Rewards reward) {
        user.setPoints(user.getPoints() + reward.getPricePoints());
         
        // TODO: user.setRewards(new ArrayList<Rewards>()); si la lista es NULL
        user.getRewards().add(reward);
        userRepository.save(user);
    }
    
    public void assignRewardToUser(Integer userId, Integer rewardsId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Rewards reward = rewardsRepository.findById(rewardsId).orElseThrow(() -> new RuntimeException("Logro no encontrado"));
        
        user.getRewards().add(reward);
        reward.getUsers().add(user);
        
        userRepository.save(user);
        rewardsRepository.save(reward);
    }
    
}
