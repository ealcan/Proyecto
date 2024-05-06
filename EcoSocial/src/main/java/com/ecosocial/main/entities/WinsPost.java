package com.ecosocial.main.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("wins")
public class WinsPost extends Post {
	
     @ManyToOne
	 @JoinColumn(name = "wins_id")
	 private Wins win;
	
	 private String winName;

	 private String winDescription;

	 // Getters y setters para la relación con Reward
	 public Wins getWin() {
	     return win;
	 }

	 public void setWin(Wins win) {
	     this.win = win;
	 }
	 
	 
	 public String getWinName() {
	     return winName; // Utiliza el título heredado de la clase base Post
	 }

	 public void setWinName(Wins win) {
	     super.setTitle(win.getName()); // Establece el título heredado de la clase base Post
	 }

	 // Getter y setter para rewardDescription
	 public String getWinDescription() {
	     return winDescription;
	 }

	 public void setWinDescription(Wins win) {
	        super.setContent(win.getDescription());
	 }

    
}
