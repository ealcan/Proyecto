package com.ecosocial.main.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.controller.dto.*;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.UserWins;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.repository.UserWinsRepository;

@Service
public class UserWinsService {
	
	@Autowired
	UserWinsRepository userWinsRepository;
	
	public List<UserWinsDto> mapUserWinsToDTO(List<Wins> userWins) {
	    List<UserWinsDto> userWinsDTOList = new ArrayList<>();
	    for (Wins win : userWins) {
	        UserWinsDto dto = new UserWinsDto();
	        dto.setName(win.getName());
	        dto.setDescription(win.getDescription());
	        dto.setRewardsPoints(win.getRewardsPoints());
	        userWinsDTOList.add(dto);
	    }
	    return userWinsDTOList;
	}
	
    public Set<Wins> getVerifiedWinsForUser(User user) {
        Set<UserWins> userWins = userWinsRepository.findByUserAndVerifiedIsTrue(user);
        Set<Wins> verifiedWins = new HashSet<>();
        for (UserWins userWin : userWins) {
            verifiedWins.add(userWin.getWin());
        }
        return verifiedWins;
    }
    


    public Set<Wins> getUnVerifiedWinsForUser(User user) {
        Set<UserWins> userWins = userWinsRepository.findByUserAndVerifiedIsFalse(user);
        Set<Wins> verifiedWins = new HashSet<>();
        for (UserWins userWin : userWins) {
            verifiedWins.add(userWin.getWin());
        }
        return verifiedWins;
    }
    
    public void validateWin(User user, Wins win) {
        // Buscar la entrada en la tabla Usuario_Desafio correspondiente al usuario y desafío dados
        UserWins userWin = userWinsRepository.findByUserAndWin(user, win);
        
        if (userWin != null) {
            // Cambiar el estado de validación a true
            userWin.setVerified(true);
            userWinsRepository.save(userWin);
        } else {
            // El código de verificación no es válido para el usuario y desafío dados
            // Manejar el error de acuerdo a tus requerimientos
        }
    }
}
