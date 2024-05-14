package com.ecosocial.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.controller.dto.RewardsDto;
import com.ecosocial.main.controller.dto.UserDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.repository.UserRepository;
import com.ecosocial.main.repository.WinsRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RewardsRepository rewardsRepository;
    
    @Autowired
    private WinsRepository winsRepository;
    
    public List<UserDto> getAllUsers(){
		List<User> data = userRepository.findAll();
		List<UserDto> result = new ArrayList<UserDto>();
		
		for (User u : data) {
			UserDto userDto = new UserDto();
			userDto.setUsername(u.getUsername());
			userDto.setEmail(u.getEmail());
			userDto.setPoints(u.getPoints());
			userDto.setRewards(u.getRewards());
			userDto.setWins(u.getWins());
			userDto.getRankingPoints();
			result.add(userDto);
		}
		return result;
	}
    
    public User getUserById2(Integer idUser){
        List<User> users = userRepository.findUserById(idUser);
        if (!users.isEmpty()) {
            return users.get(0); // Devuelve el primer usuario de la lista
        } else {
            return null; // Si la lista está vacía, devuelve null
        }
    }
    
    public List<UserDto> getUserById(Integer idUser) {
		List<User> data = new ArrayList<User>();
		if (idUser != null) {
			data = userRepository.findUserById(idUser);			
		}
		List<UserDto> result = new ArrayList<UserDto>();
		for (User u: data) {
			UserDto userDto = new UserDto();
			userDto.setUsername(u.getUsername());
			userDto.setEmail(u.getEmail());
			userDto.setPoints(u.getPoints());
			userDto.setRewards(u.getRewards());
			userDto.setWins(u.getWins());
			userDto.getRankingPoints();
			result.add(userDto);
		}
		return result;
	}

    public void assignWin(User user, Wins win) {
        
        // TODO: user.setRewards(new ArrayList<Rewards>()); si la lista es NULL
        user.getWins().add(win);
        userRepository.save(user);
    }

    public String assignReward(User user, Rewards reward) {
    	if (user.getPoints() < reward.getPricePoints()) {
    		
    		return "No tienes puntos suficientes ¡Sigue trabajando!";
    	}
    	else {
            user.setPoints(user.getPoints() - reward.getPricePoints());
            
            // TODO: user.setRewards(new ArrayList<Rewards>()); si la lista es NULL
            user.getRewards().add(reward);
            userRepository.save(user);
            return "¡Felicidades! Has reclamado tu premio";
    	}
    	
    }
    
    public void assignRewardToUser(Integer userId, Integer rewardsId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Rewards reward = rewardsRepository.findById(rewardsId).orElseThrow(() -> new RuntimeException("Logro no encontrado"));
        
        user.getRewards().add(reward);
        reward.getUsers().add(user);
        
        userRepository.save(user);
        rewardsRepository.save(reward);
    }
    
    public List<Wins> getUserWins(int userId) {
        // Obtener el usuario por su ID
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Obtener las wins asociadas al usuario y convertirlas a una lista
            Set<Wins> winsSet = user.getWins();
            List<Wins> winsList = new ArrayList<>(winsSet);
            return winsList;
        } else {
            // Manejo de error si el usuario no se encuentra
            throw new RuntimeException("Usuario no encontrado");
        }
    }
    
//    public List<User> getUsersWithVerifiedWins(Integer userId) {
//        return userRepository.findUsersWithVerifiedWins(userId);
//    }
//    
    public List<Rewards> getUserRewards(int userId) {
        // Obtener el usuario por su ID
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Obtener las wins asociadas al usuario y convertirlas a una lista
            Set<Rewards> RewardSet = user.getRewards();
            List<Rewards> rewardsList = new ArrayList<>(RewardSet);
            return rewardsList;
        } else {
            // Manejo de error si el usuario no se encuentra
            throw new RuntimeException("Usuario no encontrado");
        }
    }
    
}
