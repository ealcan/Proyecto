package com.ecosocial.main.controller;

import java.util.List;

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
    
    /*@GetMapping("/{id1}/{id2}")
    public boolean findMutualFriends(@PathVariable("id1") Integer userId, @PathVariable("id2") Integer userId2){
    	return friendshipService.areFriends(userId, userId2);
    }*/
    
    @PostMapping("/{id1}/{id2}")
    public ResponseEntity<String> addFriendship(@PathVariable("id1") Integer userId1, @PathVariable("id2") Integer userId2) {
        
        friendshipService.addFriendship(userId1, userId2);
        return ResponseEntity.ok("Friendship added successfully");
       
    }
}
