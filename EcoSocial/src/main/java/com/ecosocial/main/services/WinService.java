package com.ecosocial.main.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.controller.dto.RewardsDto;
import com.ecosocial.main.controller.dto.WinsDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.repository.WinsRepository;

@Service
public class WinService {
	@Autowired	
	WinsRepository winsRepository;
	
	//Encuentra todos los logros
	public List<WinsDto> getAllRewards(){
		List<Wins> data = winsRepository.findAll();
		List<WinsDto> result = new ArrayList<WinsDto>();
		for (Wins r : data) {
			WinsDto winsDto = new WinsDto();
			winsDto.setName(r.getName());
			winsDto.setDescription(r.getDescription());
			winsDto.setRewardsPoints(r.getRewardsPoints());
			result.add(winsDto);
		}
		return result;
	}
	
	//Encuentra el logro según su id
	public WinsDto getWinById(Integer winId) {
		Wins win = winsRepository.findById(winId).orElse(null);
		WinsDto winsDto = new WinsDto();
		winsDto.setName(win.getName());
		winsDto.setDescription(win.getDescription());
		winsDto.setRewardsPoints(win.getRewardsPoints());
        return winsDto;
    }
	
	//Encuentra los logros por el ID del usuario
	public List<Wins> getWinsByUserId(Integer idUser) {
		List<Wins> data = winsRepository.findByUsersId(idUser);
		List<WinsDto> result = new ArrayList<WinsDto>();
		for (Wins r : data) {
			WinsDto winsDto = new WinsDto();
			winsDto.setName(r.getName());
			winsDto.setDescription(r.getDescription());
			winsDto.setRewardsPoints(r.getRewardsPoints());
			result.add(winsDto);
		}
		return data;
	}
	

	//Encuentra los logros por el username del usuario
	public List<WinsDto> getWinsByUserName(String userName) {
		List<Wins> data = winsRepository.findByUsersUsername(userName);
		List<WinsDto> result = new ArrayList<WinsDto>();
		for (Wins r : data) {
			WinsDto winsDto = new WinsDto();
			winsDto.setName(r.getName());
			winsDto.setDescription(r.getDescription());
			winsDto.setRewardsPoints(r.getRewardsPoints());
			result.add(winsDto);
		}
		return result;
	}
	
	//Encuentra los logros por su ID y por su username
	public List<WinsDto> getRewardsByUser(Integer idUser, String username) {
		List<Wins> data = new ArrayList<Wins>();
		if (idUser != null) {
			data = winsRepository.findByUsersId(idUser);			
		} else if (username != null ) {
			data = winsRepository.findByUsersUsername(username);			
		}
		List<WinsDto> result = new ArrayList<WinsDto>();
		for (Wins r : data) {
			WinsDto winsDto = new WinsDto();
			winsDto.setName(r.getName());
			winsDto.setDescription(r.getDescription());
			winsDto.setRewardsPoints(r.getRewardsPoints());
			result.add(winsDto);
		}
		return result;
	}
	
	//Comprueba si el logro existe
	public boolean existsReward(Wins win) {
		if (winsRepository.existsByName(win.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Crea un nuevo logro
	public Wins saveRewad(Wins win) {
		return winsRepository.save(win);
	}
}
