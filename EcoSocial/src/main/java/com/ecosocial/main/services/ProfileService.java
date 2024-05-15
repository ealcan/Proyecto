package com.ecosocial.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.controller.dto.ProfileDto;
import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.FriendshipRepository;
import com.ecosocial.main.repository.ProfileRepository;
import com.ecosocial.main.repository.UserRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	FriendshipRepository friendshipRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<ProfileDto> getFriendshipByUser(Integer userId){
		List<User> friendship = friendshipRepository.findFriendUsersByUserId1(userId);
		List<ProfileDto> result = new ArrayList<ProfileDto>();
		for (User u : friendship) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setName(u.getProfile().getName());
			profileDto.setLastName(u.getProfile().getLastname());
			profileDto.setProfile_image(u.getProfile().getProfileImage());
			profileDto.setUsername(u.getUsername());
			profileDto.setEmail(u.getEmail());
			profileDto.setPoints(u.getPoints());
			profileDto.setRewards(u.getRewards());
			profileDto.setWins(u.getWins());
			profileDto.setPosts(u.getProfile().getPosts());
			profileDto.getRankingPoints();
			result.add(profileDto);
		}
		return result;
	}
	
	public List<ProfileDto> getFriendshipByUser2(Integer userId){
		List<User> friendship = friendshipRepository.findFriendUsersByUserId1(userId);
		List<ProfileDto> result = new ArrayList<ProfileDto>();
		for (User u : friendship) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setName(u.getProfile().getName());
			profileDto.setLastName(u.getProfile().getLastname());
			profileDto.setProfile_image(u.getProfile().getProfileImage());
			profileDto.setUsername(u.getUsername());
			profileDto.setEmail(u.getEmail());
			profileDto.setPoints(u.getPoints());
			profileDto.setRewards(u.getRewards());
			profileDto.setWins(u.getWins());
			profileDto.setPosts(u.getProfile().getPosts());
			profileDto.getRankingPoints();
			result.add(profileDto);
		}
		List<User> user = userRepository.findUserById(userId);
		for (User u : user) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setName(u.getProfile().getName());
			profileDto.setLastName(u.getProfile().getLastname());
			profileDto.setProfile_image(u.getProfile().getProfileImage());
			profileDto.setUsername(u.getUsername());
			profileDto.setEmail(u.getEmail());
			profileDto.setPoints(u.getPoints());
			profileDto.setRewards(u.getRewards());
			profileDto.setPosts(u.getProfile().getPosts());
			profileDto.setWins(u.getWins());
			result.add(profileDto);
		}
		return result;
	}
	
	public List<ProfileDto> getRanking (Integer userid){
		List<ProfileDto> ranking = getFriendshipByUser2(userid);
		ranking.sort((u1, u2) -> Double.compare(u2.getRankingPoints(), u1.getRankingPoints()));
		
		return ranking;
	}
	
	public List<ProfileDto> getGlobalRanking(){
		List<Profile> profiles = profileRepository.findAll();
		List<ProfileDto> result = new ArrayList<ProfileDto>();
		for (Profile r : profiles) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setUsername(r.getUser().getUsername());
			profileDto.setEmail(r.getUser().getEmail());
			profileDto.setPoints(r.getUser().getPoints());
			profileDto.setName(r.getName());
			profileDto.setLastName(r.getLastname());
			profileDto.setProfile_image(r.getProfileImage());
			profileDto.setRewards(r.getUser().getRewards());
			profileDto.setWins(r.getUser().getWins());
			profileDto.setPosts(r.getPosts());
			profileDto.getRankingPoints();
			result.add(profileDto);
		}
		result.sort((u1, u2) -> Double.compare(u2.getRankingPoints(), u1.getRankingPoints()));
	    if (result.size() > 10) {
	        result = result.subList(0, 10);
	    }
		return result;
	}
	
	public List<ProfileDto> getAllProfiles(){
		List<Profile> profiles = profileRepository.findAll();
		List<ProfileDto> result = new ArrayList<ProfileDto>();
		for (Profile r : profiles) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setUsername(r.getUser().getUsername());
			profileDto.setEmail(r.getUser().getEmail());
			profileDto.setPoints(r.getUser().getPoints());
			profileDto.setName(r.getName());
			profileDto.setLastName(r.getLastname());
			profileDto.setProfile_image(r.getProfileImage());
			profileDto.setRewards(r.getUser().getRewards());
			profileDto.setWins(r.getUser().getWins());
			profileDto.setPosts(r.getPosts());
			profileDto.getRankingPoints();
			result.add(profileDto);
		}
		return result;
	}
	
	public ProfileDto getProfileById(Integer ProfileId) {
		Profile profile = profileRepository.findById(ProfileId).orElse(null);
		ProfileDto profileDto = new ProfileDto();
		profileDto.setUsername(profile.getUser().getUsername());
		profileDto.setEmail(profile.getUser().getEmail());
		profileDto.setPoints(profile.getUser().getPoints());
		profileDto.setName(profile.getName());
		profileDto.setLastName(profile.getLastname());
		profileDto.setProfile_image(profile.getProfileImage());
		profileDto.setRewards(profile.getUser().getRewards());
		profileDto.setWins(profile.getUser().getWins());
		profileDto.setPosts(profile.getPosts());
		profileDto.getRankingPoints();
		return profileDto;
	}
	
	public Profile getProfileById2(Integer ProfileId) {
		Profile profile = profileRepository.findById(ProfileId).orElse(null);
		
		return profile;
	}
}