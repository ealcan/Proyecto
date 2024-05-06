package com.ecosocial.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecosocial.main.controller.dto.PostDto;
import com.ecosocial.main.controller.dto.UserDto;
import com.ecosocial.main.entities.Post;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    // Método para obtener todos los posts
    public List<PostDto> getAllPosts() {
    	List<Post> post = postRepository.findAll();
    	List<PostDto> result = new ArrayList<PostDto>();
    	
    	for (Post p : post) {
    		PostDto postDto = new PostDto();
    		postDto.setTitle(p.getTitle());
    		postDto.setContent(p.getContent());
    		postDto.setPublishedAt(LocalDateTime.now());
    		result.add(postDto);
    	}
    	return result;
//       return postRepository.findAll();
    }
    

    // Método para obtener un post por su ID
    public List<PostDto> getPostById(Integer id) {
        List<Post> data = new ArrayList<Post>();
        if (id != null) {
        	data = postRepository.findPostById(id);
        }
        List<PostDto> result = new ArrayList<PostDto>();
        for (Post p: data) {
        	PostDto postDto = new PostDto();
    		postDto.setTitle(p.getTitle());
    		postDto.setContent(p.getContent());
    		postDto.setPublishedAt(LocalDateTime.now());
    		result.add(postDto);
    	}
    	return result;
        
    }
    

    // Método para actualizar un post existente
    public Post updatePost(Integer id, Post updatedPost) {
        if (postRepository.existsById(id)) {
            updatedPost.setId(id);
            return postRepository.save(updatedPost);
        }
        return null; // Manejar el caso en el que el post no exista
    }

    // Método para eliminar un post
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
