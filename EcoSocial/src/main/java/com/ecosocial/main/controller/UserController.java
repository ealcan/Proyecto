package com.ecosocial.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosocial.main.controller.dto.UserDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.repository.UserRepository;
import com.ecosocial.main.repository.WinsRepository;
import com.ecosocial.main.services.FriendshipService;
import com.ecosocial.main.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WinsRepository winRepository;

    @Autowired
    private RewardsRepository rewardRepository;
    
    @Autowired
    private UserService userService;
    

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public List<UserDto> getUser(@PathVariable("id") Integer userId) {
    	return userService.getUserById(userId);
    }

    // Crear un nuevo usuario
    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Verificar si el nombre de usuario ya existe en la base de datos
        if (userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>("El nombre de usuario ya está en uso.", HttpStatus.BAD_REQUEST);
        }

        // Si el nombre de usuario no existe, crear el usuario
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user.setId(id); // Aseguramos que el ID sea el correcto
            User updatedUser = userRepository.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //Test Area
    
    @PostMapping("/{userId}/assign-win/{winId}")
    public ResponseEntity<?> assignWinToUser(@PathVariable Integer userId, @PathVariable Integer winId) {
        User user = userRepository.findById(userId).orElse(null);
        Wins win = winRepository.findById(winId).orElse(null);

        if (user == null || win == null) {
            return ResponseEntity.badRequest().build();
        }

        userService.assignWin(user, win);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/assign-reward/{rewardId}")
    public ResponseEntity<?> assignRewardToUser(@PathVariable Integer userId, @PathVariable Integer rewardId) {
        User user = userRepository.findById(userId).orElse(null);
        Rewards reward = rewardRepository.findById(rewardId).orElse(null);

        if (user == null || reward == null) {
            return ResponseEntity.badRequest().build();
        }

        userService.assignReward(user, reward);
        return ResponseEntity.ok().build();
    }
    
}

