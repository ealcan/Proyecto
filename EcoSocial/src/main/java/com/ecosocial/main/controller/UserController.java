package com.ecosocial.main.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ecosocial.main.controller.dto.UserRewardsDto;
import com.ecosocial.main.controller.dto.UserWinsDto;
import com.ecosocial.main.entities.*;
import com.ecosocial.main.repository.UserRepository;
import com.ecosocial.main.repository.UserWinsRepository;
import com.ecosocial.main.repository.WinsRepository;
import com.ecosocial.main.repository.ProfileRepository;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecosocial.main.controller.dto.UserDto;
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
    private ProfileRepository profileRepository;
    
    @Autowired
    private UserWinsService userWinService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private FriendshipService friendshipService;

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
    
    //Obtener un usuario por su username
    @GetMapping("/find/{username}")
    public List<UserDto> getUserbyName(@PathVariable("username") String username){
    	return userService.getUserByUsername(username);
    }

    // Crear un nuevo usuario
    @PostMapping("/")
    public RedirectView createUser(@RequestBody UserAndProfileData data) {
        // Verificar si el nombre de usuario ya existe en la base de datos
        if (userRepository.existsByUsername(data.getUsername())) {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("login-error"); // URL de destino
            return redirectView;
            
        }
        else if(userRepository.existsByEmail(data.getEmail())){
        	RedirectView redirectView = new RedirectView();
            redirectView.setUrl("login-error"); // URL de destino
            return redirectView;
        }
        else {
        	User user = new User();
        	user.setUsername(data.getUsername());
        	user.setPassword(data.getPassword());
        	user.setEmail(data.getEmail());
	        userRepository.save(user);
	        
	        Profile profile = new Profile();
        	profile.setName(data.getName());
        	profile.setLastname(data.getLastname());
	        profileRepository.save(profile);
	        
	        RedirectView redirectView = new RedirectView();
	        redirectView.setUrl("/profiles/"+profile.getId()); // URL de destino
	        return redirectView;
        }
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public RedirectView updateUser(@PathVariable int id, @RequestBody Map<String, String> userData) {
    	String username = userData.get("username");
        String email = userData.get("email");
    	
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        user.setUsername(username);
        user.setEmail(email);
        
        userRepository.save(user);
    	
    		
    	RedirectView redirectView = new RedirectView();
    	redirectView.setUrl("/users/"+user.getId()); // URL de destino
        return redirectView;

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
    
    //Test Area
    
    @GetMapping("/{userId}/verified-wins")
    public ResponseEntity<Set<Wins>> getVerifiedWinsForUser(@PathVariable Integer userId) {
        // Aquí debes obtener el usuario de la base de datos según el userId
        // Supongamos que tienes un UserRepository para eso
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Set<Wins> verifiedWins = userWinService.getVerifiedWinsForUser(user);
        return ResponseEntity.ok(verifiedWins);
    }

    @GetMapping("/{userId}/unverified-wins")
    public ResponseEntity<Set<Wins>> getUnVerifiedWinsForUser(@PathVariable Integer userId) {
        // Aquí debes obtener el usuario de la base de datos según el userId
        // Supongamos que tienes un UserRepository para eso
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Set<Wins> verifiedWins = userWinService.getUnVerifiedWinsForUser(user);
        return ResponseEntity.ok(verifiedWins);
    }
    
    @PostMapping("/{userId}/verify-win/{winId}")
    public String verifyWin(@PathVariable Integer userId, @PathVariable Integer winId, @RequestBody String verificationCode) {
    	User user = userRepository.findById(userId).orElse(null);
    	Wins win = winRepository.findById(winId).orElse(null);
    	
    	if(user == null || win == null) {
    		return "Usuario o Win no encontrada";
    	}
    	else if (verificationCode.length() < 11){
    		return "Codigo de Verificación incorrecto";
    	}
    	else {
    		user.setPoints(user.getPoints() + win.getRewardsPoints());
    		userWinService.validateWin(user, win);
    		return "Logro verificado correctamente! Buen trabajo.";
    	}
    }
    
    @GetMapping("/login-error")
    public String loginError() {
    	return "Usuario o contraseña incorrectos";
    }
    
    @PostMapping("/login")
    public RedirectView loginUser(@RequestBody Map<String, String> loginData) {
    	String username = loginData.get("username");
        String password = loginData.get("password");
    	
    	User user = userRepository.findByUsername(username).orElse(null);
    	
    	if (user == null) {
    		RedirectView redirectView = new RedirectView();
        	redirectView.setUrl("login-error"); // URL de destino
            return redirectView;
    	}
    	else if (!user.getPassword().equals(password)) {
    		RedirectView redirectView = new RedirectView();
        	redirectView.setUrl("login-error"); // URL de destino
            return redirectView;
    	}
    	RedirectView redirectView = new RedirectView();
    	redirectView.setUrl("/profiles/"+user.getId()); // URL de destino
        return redirectView;

    }
    
    @PutMapping("{id}/password")
    public String changePassword(@PathVariable int id, @RequestBody Map<String, String> userData) {
    	
    	String email = userData.get("email");
    	String password = userData.get("password");
    	
    	User user = userRepository.findById(id).orElse(null);
    	
    	if (user == null) {
    		return "Cannot find the user";
    	}
    	
    	else if (!user.getEmail().equals(email)) {
    		return user.getEmail()+' '+email;
    	}
    	else {
    		user.setPassword(password);
    		userRepository.save(user);
    		return "Contraseña actualizada";
    	}
    }
}
    

