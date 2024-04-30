package com.ecosocial.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ecosocial.main.controller.dto.UserRewardsDto;
import com.ecosocial.main.controller.dto.UserWinsDto;
import com.ecosocial.main.entities.*;
import com.ecosocial.main.repository.UserRepository;
import com.ecosocial.main.repository.WinsRepository;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
    
    //Test Area
    
    @GetMapping("/{userId}/wins")
    public ResponseEntity<List<Wins>> getUserWins(@PathVariable int userId) {
        // Obtener las wins del usuario especificado por userId
        List<Wins> userWins = userService.getUserWins(userId);

        // Devolver la lista de wins en formato JSON
        return new ResponseEntity<>(userWins, HttpStatus.OK);
    }
    
    @GetMapping("/{userId}/rewards")
    public ResponseEntity<List<Rewards>> getUserRewards(@PathVariable int userId) {
        // Obtener las wins del usuario especificado por userId
        List<Rewards> userRewards = userService.getUserRewards(userId);

        // Devolver la lista de wins en formato JSON
        return new ResponseEntity<>(userRewards, HttpStatus.OK);
    }

}
    

