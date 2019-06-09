package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.entities.User;
import com.stagiaires.stagiaire.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user/")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/all")
	public List<User> findUser() {
		return userService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<User> findUser(@PathVariable Long id) {
		return userService.findUser(id);
		
	}


	
	@PostMapping
	public void addStagiaire(@PathVariable(name = "id") Long id, @RequestBody User user) {
		user.setId(id);
		userService.addUser(user);
	}
	
	@PutMapping
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody User user) {
		user.setId(id);
		userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteUser(@PathVariable(name = "id") Long id) {
		userService.delete(id);
	}
	

}
