package com.ecosocial.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecosocial.main.controller.dto.RewardsDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.RewardsRepository;

@Service
public class RewardsService {
	@Autowired	
	RewardsRepository rewardsRepository;
	
	//Encuentra todos los logros
	public List<RewardsDto> getAllRewards(){
		List<Rewards> data = rewardsRepository.findAll();
		List<RewardsDto> result = new ArrayList<RewardsDto>();
		for (Rewards r : data) {
			RewardsDto rewardsDto = new RewardsDto();
			rewardsDto.setName(r.getName());
			rewardsDto.setDescription(r.getDescription());
			rewardsDto.setPricePoints(r.getPricePoints());
			result.add(rewardsDto);
		}
		return result;
	}
	
	//Encuentra el logro según su id
	public RewardsDto getRewardById(Integer RewardId) {
		Rewards reward = rewardsRepository.findById(RewardId).orElse(null);
		RewardsDto rewardsDto = new RewardsDto();
		rewardsDto.setName(reward.getName());
		rewardsDto.setDescription(reward.getDescription());
		rewardsDto.setPricePoints(reward.getPricePoints());
        return rewardsDto;
    }
	
	//Encuentra los logros por el ID del usuario
	public List<Rewards> getRewardsByUserId(Integer idUser) {
		List<Rewards> data = rewardsRepository.findByUsersId(idUser);
		List<RewardsDto> result = new ArrayList<RewardsDto>();
		for (Rewards r : data) {
			RewardsDto rewardsDto = new RewardsDto();
			rewardsDto.setName(r.getName());
			rewardsDto.setDescription(r.getDescription());
			rewardsDto.setPricePoints(r.getPricePoints());
			result.add(rewardsDto);
		}
		return data;
	}
	

	//Encuentra los logros por el username del usuario
	public List<RewardsDto> getRewardsByUserName(String userName) {
		List<Rewards> data = rewardsRepository.findByUsersUsername(userName);
		List<RewardsDto> result = new ArrayList<RewardsDto>();
		for (Rewards r : data) {
			RewardsDto rewardsDto = new RewardsDto();
			rewardsDto.setName(r.getName());
			rewardsDto.setDescription(r.getDescription());
			rewardsDto.setPricePoints(r.getPricePoints());
			result.add(rewardsDto);
		}
		return result;
	}
	
	//Encuentra los logros por su ID y por su username
	public List<RewardsDto> getRewardsByUser(Integer idUser, String username) {
		List<Rewards> data = new ArrayList<Rewards>();
		if (idUser != null) {
			data = rewardsRepository.findByUsersId(idUser);			
		} else if (username != null ) {
			data = rewardsRepository.findByUsersUsername(username);			
		}
		List<RewardsDto> result = new ArrayList<RewardsDto>();
		for (Rewards r : data) {
			RewardsDto rewardsDto = new RewardsDto();
			rewardsDto.setName(r.getName());
			rewardsDto.setDescription(r.getDescription());
			rewardsDto.setPricePoints(r.getPricePoints());
			result.add(rewardsDto);
		}
		return result;
	}
	
	//Comprueba si el logro existe
	public boolean existsReward(Rewards reward) {
		if (rewardsRepository.existsByName(reward.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Crea un nuevo logro
	public Rewards saveRewad(Rewards reward) {
		return rewardsRepository.save(reward);
	}
}
