package com.ecosocial.main.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.Friendship;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.FriendshipRepository;
import com.ecosocial.main.repository.UserRepository;

@Service
public class FriendshipService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FriendshipRepository friendshipRepository;

	public FriendshipService(FriendshipRepository friendshipRepository) {
		this.friendshipRepository = friendshipRepository;
	}
	
	public List<User> findFriendshipsByUserId(Integer userId) {
        return friendshipRepository.findFriendUsersByUserId1(userId);
    }
	
	public void addFriendship(Integer userId, Integer friendId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + userId));

        User friend = userRepository.findById(friendId)
            .orElseThrow(() -> new RuntimeException("Amigo no encontrado: " + friendId));

        	Friendship userFriend = new Friendship();
            userFriend.setUser1(user);
            userFriend.setUser2(friend);

            friendshipRepository.save(userFriend);
        
    }
	
	public boolean areFriends(Integer userId1, Integer userId2) {
        List<User> friendships = friendshipRepository.findFriendshipsByUserIds(userId1, userId2);
        return !friendships.isEmpty();
    }
	

}
