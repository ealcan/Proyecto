package com.ecosocial.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecosocial.main.entities.Friendship;
import com.ecosocial.main.entities.User;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
	
	Optional<Friendship> findById(Integer id);
	
	@Query("SELECT f.user2 FROM Friendship f WHERE f.user1.id = :userId1")
    List<User> findFriendUsersByUserId1(@Param("userId1") Integer userId1);

	@Query("SELECT f.user2 FROM Friendship f WHERE (f.user1.id = :userId1 AND f.user2.id = :userId2) OR (f.user1.id = :userId2 AND f.user2.id = :userId1)")
    List<User> findFriendshipsByUserIds(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2);
	
}
