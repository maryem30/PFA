package stage.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import stage.dao.UserRepository;

import stage.dao.UserRepository;
import stage.entities.user;
import stage.service.UserService;

@CrossOrigin("*")
@RestController

@RequestMapping("/user/")
public class UserController {
	
	
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/all")
	public List<user> findUser() {
		return userService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<user> findUser(@PathVariable Long id) {
		return userService.findUser(id);
		
	}


	
	
	@GetMapping(value = "/page")

	public Page<user> showPage(@RequestParam(defaultValue = "1") int page) {
		return userRepository.findAll(new PageRequest(page, 10));

	}
	
	
	
	@PostMapping
	public void addUser(@PathVariable(name = "id") Long id, @RequestBody user user) {
		user.setId(id);
		userService.addUser(user);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable(name = "id") Long id, @RequestBody user user) {
		user.setId(id);
		userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteUser(@PathVariable(name = "id") Long id) {
		userService.delete(id);
	}
	

}
