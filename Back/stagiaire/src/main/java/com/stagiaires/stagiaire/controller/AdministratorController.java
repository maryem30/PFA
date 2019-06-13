package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.stagiaires.stagiaire.dao.AdministratorRepository;
import com.stagiaires.stagiaire.entities.Administrator;
import com.stagiaires.stagiaire.entities.Stagiaire;
import com.stagiaires.stagiaire.services.AdministratorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/administrators/")
public class AdministratorController {

	private AdministratorService administratorService;
	@Autowired
	private AdministratorRepository administratorRepository;


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
	
	@GetMapping(value = "/page")

	public Page<Administrator> showPage(@RequestParam(defaultValue = "0") int page) {
		return administratorRepository.findAll(new PageRequest(page, 10));

	}

	@PostMapping
	public void addAdministrator(@PathVariable(name = "id") Long id, @RequestBody Administrator administrator) {
		administrator.setId(id);
		administratorService.addAdministrator(administrator);
	}

	@PutMapping
	public void updateAdministrator(@PathVariable(name = "id") Long id, @RequestBody Administrator administrator) {
		administrator.setId(id);
		administratorService.updateAdministrator(administrator);
	}

	@DeleteMapping("/{id}")
	public void deleteAdministrator(@PathVariable(name = "id") Long id) {
		administratorService.delete(id);

	}

}
