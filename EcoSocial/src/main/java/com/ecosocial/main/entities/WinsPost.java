package com.ecosocial.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("wins")
public class WinsPost extends Post {
	
	 @JsonIgnore
     @ManyToOne
	 @JoinColumn(name = "wins_id")
	 private Wins win;
     
 	public WinsPost() {
		// Puedes inicializar valores predeterminados aquí si es necesario
}
 
 // Constructor
 	public WinsPost(Wins win) {
 		this.win = win;
 		super.setTitle(win.getName());
 		super.setContent(win.getDescription());
 }
	

	 // Getters y setters para la relación con Reward
	 public Wins getWin() {
	     return win;
	 }

	 public void setWin(Wins win) {
	     this.win = win;
	 }
	 
    
}
