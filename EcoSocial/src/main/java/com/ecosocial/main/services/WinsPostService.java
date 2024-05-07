package com.ecosocial.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosocial.main.entities.WinsPost;
import com.ecosocial.main.exception.ResourceNotFoundException;
import com.ecosocial.main.repository.WinsPostRepository;

@Service
public class WinsPostService {

	@Autowired
	WinsPostRepository winsPostRepository;
	
	public List<WinsPost> getAllWinsPosts() {
        return winsPostRepository.findAll();
    }

    public Optional<WinsPost> getWinsPostById(Integer id) {
        return winsPostRepository.findById(id);
    }

    public WinsPost createWinsPost(WinsPost winsPost) {
        return winsPostRepository.save(winsPost);
    }

    public WinsPost updateWinsPost(Integer id, WinsPost winsPost) {
        if (winsPostRepository.existsById(id)) {
            winsPost.setId(id);
            return winsPostRepository.save(winsPost);
        } else {
            throw new ResourceNotFoundException("Wins Post", "id", id);
        }
    }

    public void deleteRewardPost(Integer id) {
        winsPostRepository.deleteById(id);
    }
}
