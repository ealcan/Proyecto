package com.ecosocial.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.*;
import com.ecosocial.main.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void assignWin(User user, Wins win) {
        user.setPoints(user.getPoints() + win.getRewardsPoints());
        user.setWins(win);
        userRepository.save(user);
    }

    public void assignReward(User user, Rewards reward) {
        user.setPoints(user.getPoints() - reward.getPricePoints());
        user.setReward(reward);
        userRepository.save(user);
    }
}
