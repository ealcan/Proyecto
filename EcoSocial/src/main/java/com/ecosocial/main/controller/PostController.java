package com.ecosocial.main.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosocial.main.controller.dto.PostDto;
import com.ecosocial.main.entities.Post;
import com.ecosocial.main.entities.Profile;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.PostRepository;
import com.ecosocial.main.repository.ProfileRepository;
import com.ecosocial.main.services.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private ProfileRepository profileRepository;

    // Endpoint para obtener todos los posts
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Endpoint para obtener un post por su ID
    @GetMapping("/{id}")
    public List<PostDto> getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    // Endpoint para crear un nuevo post
    @PostMapping("/")
    public ResponseEntity<Post> createProfile(@RequestBody Post post) {
        Post newPost = postRepository.save(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }


    // Endpoint para actualizar un post existente
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            post.setId(id); // Aseguramos que el ID sea el correcto
            Post updatedPost = postRepository.save(post);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    // Endpoint para eliminar un post por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
        	postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}