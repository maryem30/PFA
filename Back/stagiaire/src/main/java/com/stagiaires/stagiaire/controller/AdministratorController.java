package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.entities.Administrator;
import com.stagiaires.stagiaire.services.AdministratorService;
@CrossOrigin("*")
@RestController
@RequestMapping("/administrators/")
public class AdministratorController {
	
	private AdministratorService administratorService;

	@Autowired
	public AdministratorController(AdministratorService administratorService) {
		super();
		this.administratorService = administratorService;
	}

	@GetMapping(value = "/all")
	public List<Administrator> findAdministrator() {
		return administratorService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Administrator> findAdministrator(@PathVariable Long id) {
		return administratorService.findAdministrator(id);
		
	}

	@RequestMapping( value="/deleteAdministrator{id}", method = RequestMethod.DELETE)
	public void deleteAdministrator(@PathVariable(name = "id") Long id) {
		administratorService.delete(id);

	}

	@RequestMapping(value = "/administrator/{id}", method = RequestMethod.PUT)
	public Administrator updateAdministrator(@PathVariable(name = "id") Long id, @RequestBody Administrator administrator) {
		administrator.setId(id);
		return administratorService.addAdministrator(administrator);
	}
	

}
