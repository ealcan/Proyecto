package com.ecosocial.main.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.*;
import com.ecosocial.main.repository.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WinsRepository winsRepository;
    
    @Autowired
    private RewardsRepository rewardsRepository;
    
    @Autowired
    private UserWinsRepository userWinsRepository;
    
    @Autowired
    private UserRewardsRepository userRewardsRepository;

    public List<Wins> getWinsByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            return user.getUserWins();
        } else {
            return Collections.emptyList(); // Retorna una lista vacía si el usuario no se encuentra
        }
    }

    public List<Rewards> getRewardsByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            return user.getUserRewards();
        } else {
            return Collections.emptyList(); // Retorna una lista vacía si el usuario no se encuentra
        }
    }
    
    public void asignarUserWin(Integer userId, Integer winId) {
        // Crear el objeto UserWinId con los identificadores proporcionados
        UserWinId userWinId = new UserWinId();
        userWinId.setUserId(userId);
        userWinId.setWinId(winId);

        // Crear un nuevo UserWin y asignarle el UserWinId
        UserWins userWin = new UserWins();
        userWin.setId(userWinId); // Suponiendo que tienes un setter setId en UserWin para el UserWinId

        // Guardar el UserWin en la base de datos u realizar otras operaciones necesarias
    }
    
    public void assignWin(Integer userId, Integer winId) {
    	User user = userRepository.findById(userId).orElse(null);
    	Wins win = winsRepository.findById(winId).orElse(null);
        UserWinId userWinId = new UserWinId();
        userWinId.setUserId(userId);
        userWinId.setWinId(winId);

 


    	if (user != null) {
    	    UserWins userWin = new UserWins();
    	    userWin.setId(userWinId);
    	    userWin.setUser(user);
    	    userWin.setWin(win);
    	    // Configura otros atributos de Win según sea necesario

    	    userWinsRepository.save(userWin);
    	    userRepository.save(user);
    	    winsRepository.save(win);
    	} else {
    	    // Manejo de error si el usuario no se encuentra
    	}
    }
    
    public void assignReward(Integer userId, Integer rewardId) {
    	User user = userRepository.findById(userId).orElse(null);
    	Rewards reward = rewardsRepository.findById(rewardId).orElse(null);

    	if (user != null) {
    	    UserRewards userReward = new UserRewards();
    	    userReward.setUser(user);
    	    userReward.setReward(reward);
    	    // Configura otros atributos de Win según sea necesario

    	    userRewardsRepository.save(userReward);
    	} else {
    	    // Manejo de error si el usuario no se encuentra
    	}
    }
}
    
