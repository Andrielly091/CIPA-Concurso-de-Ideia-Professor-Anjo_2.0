package br.edu.ifpe.email.novatentativa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.email.novatentativa.model.User;
import br.edu.ifpe.email.novatentativa.service.UserService;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
	
	public final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
		
	}
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
		
	}
	
	
	

}
