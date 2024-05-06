package com.ecosocial.main.controller.dto;

import com.ecosocial.main.entities.Wins;

public class WinsPostDto {
	
	private Wins win;
	
	 private String winName;

	 private String winDescription;

	public Wins getWin() {
		return win;
	}

	public void setWin(Wins win) {
		this.win = win;
	}

	public String getWinName() {
		return winName;
	}

	public void setWinName(String winName) {
		this.winName = winName;
	}

	public String getWinDescription() {
		return winDescription;
	}

	public void setWinDescription(String winDescription) {
		this.winDescription = winDescription;
	}
	 
	 
}
