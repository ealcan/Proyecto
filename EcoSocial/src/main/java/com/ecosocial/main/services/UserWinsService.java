package com.ecosocial.main.services;

import java.util.ArrayList;
import java.util.List;

import com.ecosocial.main.controller.dto.*;
import com.ecosocial.main.entities.Wins;

public class UserWinsService {
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
}
