package com.ecosocial.main.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecosocial.main.entities.User;
import com.ecosocial.main.services.FriendshipService;

@RestController
@RequestMapping("/friend")
public class FriendshipController {

	@Autowired
	private FriendshipService friendshipService;
	
	//Obtener los amigos de un usuario mediante su ID
    @GetMapping("/{id}")
    public List<User> getFriendshipsByUserId(@PathVariable("id") Integer userId){
    	return friendshipService.findFriendshipsByUserId(userId);
    }
    
    @PostMapping("/{id1}/{id2}")
    public ResponseEntity<String> addFriend(@PathVariable("id1") Integer userId, @PathVariable("id2") Integer friendId) {
        if(userId != friendId) {
        	if (friendshipService.areFriends(userId, friendId)) {
            	return new ResponseEntity<>("Ya son amigos",HttpStatus.NOT_FOUND);
            }
            else {
    	    	friendshipService.addFriendship(userId, friendId);
    	        return ResponseEntity.ok("Amigo añadido correctamente");
            }
        }
        else {
        	return new ResponseEntity<>("No puedes ser amigo de ti mismo",HttpStatus.NOT_FOUND);
        }
    }
    
}
