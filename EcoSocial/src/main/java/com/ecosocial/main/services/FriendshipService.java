package com.ecosocial.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.Friendship;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.FriendshipRepository;
import com.ecosocial.main.repository.UserRepository;

@Service
public class FriendshipService {
	
	@Autowired
	FriendshipRepository friendshipRepository;
	
	@Autowired
	UserRepository userRepository;

	public FriendshipService(FriendshipRepository friendshipRepository) {
		this.friendshipRepository = friendshipRepository;
	}
	
	public List<User> findFriendshipsByUserId(Integer userId) {
        return friendshipRepository.findFriendUsersByUserId1(userId);
    }
	
	/*public List<User> areFriends(Integer userId1, Integer userId2) {
        List<User> friendships = friendshipRepository.findFriendshipsByUserIds(userId1, userId2);
        return friendships;
	}*/
	
	/*public void addFriendship(Integer userId1, Integer userId2) {
        // Verificar si la amistad ya existe para evitar duplicados
        if (areFriends(userId1, userId2)) {
            //throw new FriendshipAlreadyExistsException("The friendship already exists");
        	System.out.println("Error");
        }

        // Crear la nueva relación de amistad
        Friendship user1 = friendshipRepository.findById(userId1).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Friendship user2 = friendshipRepository.findById(userId2).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        user1.getUsers().add(user1);
        user1.getRewards().add(reward);
        reward.getUsers().add(user);
        
        userRepository.save(user);
        rewardsRepository.save(reward);
	}*/
     
	public void addFriendship(Integer userId1, Integer userId2) {
	    User user1 = userRepository.findById(userId1).orElseThrow(() -> new RuntimeException("Usuario 1 no encontrado"));
	    User user2 = userRepository.findById(userId2).orElseThrow(() -> new RuntimeException("Usuario 2 no encontrado"));
	    
	    Friendship friendship = new Friendship();
	    friendship.setUser1(user1);
	    friendship.setUser2(user2);
	    
	    user1.getFriendships().add(friendship);
	    user2.getFriendships().add(friendship);
	    
	    userRepository.save(user1);
	    userRepository.save(user2);
	}
	
	public boolean areFriends(Integer userId1, Integer userId2) {
        List<User> friendships = friendshipRepository.findFriendshipsByUserIds(userId1, userId2);
        return !friendships.isEmpty();
    }
	

}
