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
			profileDto.setUsername(u.getUsername());
			profileDto.setPoints(u.getPoints());
			profileDto.setRewards(u.getRewards());
			profileDto.setWins(u.getWins());
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
			profileDto.setUsername(u.getUsername());
			profileDto.setPoints(u.getPoints());
			profileDto.setRewards(u.getRewards());
			profileDto.setWins(u.getWins());
			result.add(profileDto);
		}
		List<User> user = userRepository.findUserById(userId);
		for (User u : user) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setName(u.getProfile().getName());
			profileDto.setLastName(u.getProfile().getLastname());
			profileDto.setUsername(u.getUsername());
			profileDto.setPoints(u.getPoints());
			profileDto.setRewards(u.getRewards());
			profileDto.setWins(u.getWins());
			result.add(profileDto);
		}
		return result;
	}
	
	public List<ProfileDto> getRanking (Integer userid){
		List<ProfileDto> ranking = getFriendshipByUser2(userid);
		ranking.sort((u1, u2) -> Double.compare(u2.getPoints(), u1.getPoints()));
		
		return ranking;
	}
	
	public List<ProfileDto> getAllProfiles(){
		List<Profile> profiles = profileRepository.findAll();
		List<ProfileDto> result = new ArrayList<ProfileDto>();
		for (Profile r : profiles) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setUsername(r.getUser().getUsername());
			profileDto.setPoints(r.getUser().getPoints());
			profileDto.setName(r.getName());
			profileDto.setLastName(r.getLastname());
			profileDto.setRewards(r.getUser().getRewards());
			profileDto.setWins(r.getUser().getWins());
			result.add(profileDto);
		}
		return result;
	}
	
	public ProfileDto getProfileById(Integer ProfileId) {
		Profile profile = profileRepository.findById(ProfileId).orElse(null);
		ProfileDto profileDto = new ProfileDto();
		profileDto.setUsername(profile.getUser().getUsername());
		profileDto.setPoints(profile.getUser().getPoints());
		profileDto.setName(profile.getName());
		profileDto.setLastName(profile.getLastname());
		profileDto.setRewards(profile.getUser().getRewards());
		profileDto.setWins(profile.getUser().getWins());
		return profileDto;
	}
}