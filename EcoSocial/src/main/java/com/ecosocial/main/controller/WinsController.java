package com.ecosocial.main.controller;

import java.util.List;

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
import com.ecosocial.main.controller.dto.WinsDto;
import com.ecosocial.main.entities.Rewards;
import com.ecosocial.main.entities.User;
import com.ecosocial.main.entities.Wins;
import com.ecosocial.main.repository.WinsRepository;
import com.ecosocial.main.services.RewardsService;
import com.ecosocial.main.services.WinService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/wins")
public class WinsController {
	
	@Autowired
	private WinService winService;
	
	@Autowired
	private WinsRepository winRepository;
	
	//Obtener todos los logros
		@GetMapping
		public ResponseEntity<List<WinsDto>> getAllRewards(){
			List<WinsDto> wins = winService.getAllRewards();
			return new ResponseEntity<>(wins, HttpStatus.OK);
		}
		
		//Obtener logros por su ID
		@GetMapping("/{id}")
		public WinsDto getWins(@PathVariable("id") Integer winId) {
	        return winService.getWinById(winId);
	    }

		//Obtener logros por ID del usuario
		@GetMapping("/user-name/{username}")
		public ResponseEntity<List<WinsDto>> getWinsByIdUser(@PathVariable("username") String username){
			List<WinsDto> wins = winService.getWinsByUserName(username);
			return new ResponseEntity<>(wins, HttpStatus.OK);
		}
		
		//Obtener logros por ID del usuario o por e username del usuario
		@GetMapping("/user")
		public ResponseEntity<List<WinsDto>> getRewardsByUser(@RequestParam(value ="id", required = false) Integer id, @RequestParam(value = "username", required = false) String username){
			List<WinsDto> wins = winService.getWinsByUser(id, username);
			return new ResponseEntity<>(wins, HttpStatus.OK);
		}

		
		@PostMapping("/")
	    public ResponseEntity<?> createWin(@RequestBody Wins win) {
	        // Verificar si el nombre de usuario ya existe en la base de datos
	        if (winRepository.existsByName(win.getName())) {
	            return new ResponseEntity<>("El logro ya existe.", HttpStatus.BAD_REQUEST);
	        }

	        // Si el nombre de usuario no existe, crear el usuario
	        Wins createdWin = winRepository.save(win);
	        return new ResponseEntity<>(createdWin, HttpStatus.CREATED);
	    }
}
