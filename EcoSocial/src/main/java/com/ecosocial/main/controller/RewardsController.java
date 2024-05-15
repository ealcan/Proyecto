package com.ecosocial.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecosocial.main.controller.dto.ProfileDto;
import com.ecosocial.main.controller.dto.RewardsDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.repository.RewardsRepository;
import com.ecosocial.main.services.RewardsService;
import com.ecosocial.main.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	@Autowired
	private RewardsService rewardsService;
	
	//Obtener todos los logros
	@GetMapping
	public ResponseEntity<List<RewardsDto>> getAllRewards(){
		List<RewardsDto> rewards = rewardsService.getAllRewards();
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
	
	//Obtener logros por su ID
	@GetMapping("/{id}")
	public RewardsDto getRewards(@PathVariable("id") Integer rewardId) {
        return rewardsService.getRewardById(rewardId);
    }

	//Obtener logros por ID del usuario
	@GetMapping("/user-name/{username}")
	public ResponseEntity<List<RewardsDto>> getRewardsByIdUser(@PathVariable("username") String username){
		List<RewardsDto> rewards = rewardsService.getRewardsByUserName(username);
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}

	//Obtener logros por ID del usuario o por e username del usuario (en el url sería localhost:8080/user?id= o /username=)
	@GetMapping("/user")
	public ResponseEntity<List<RewardsDto>> getRewardsByUser(@RequestParam(value ="id", required = false) Integer id, @RequestParam(value = "username", required = false) String username){
		List<RewardsDto> rewards = rewardsService.getRewardsByUser(id, username);
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
	
	//No funciona, lo llena todo de NULL
	@PostMapping("/")
	//Verificar si ya existe el logro en la base de datos
	public ResponseEntity<?> createReward(@RequestBody Rewards reward){
		
		//Llamamos al método del service que comprueba si existe
		boolean exists = rewardsService.existsReward(reward);
		
		if(exists) {
			return new ResponseEntity<>("El logro ya existe.", HttpStatus.BAD_REQUEST);
		}
			
			Rewards createReward = rewardsService.saveRewad(reward);
			return new ResponseEntity<>(createReward, HttpStatus.CREATED);
		
	}	
	
    //Test
    @GetMapping("/html")
    public ModelAndView showProfile(Model model) {
        // Aquí obtienes el perfil de alguna manera, por ejemplo, desde una base de datos
        RewardsDto reward = rewardsService.getRewardById(2); // Suponiendo que tienes un método obtenerPerfil() que devuelve un objeto Profile
        model.addAttribute("reward", reward);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
