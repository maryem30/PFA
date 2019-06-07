package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.dao.StagiaireRepository;
import com.stagiaires.stagiaire.entities.Stagiaire;
import com.stagiaires.stagiaire.services.StagiaireService;
@CrossOrigin("*")
@RestController
@RequestMapping("/stagiaires/")
public class StagiaireController {
	
	private StagiaireService stagiaireService;

	@Autowired
	private StagiaireRepository stagiaireRepository;
	@Autowired
	public StagiaireController(StagiaireService stagiaireService) {
		super();
		this.stagiaireService = stagiaireService;
	}

	@GetMapping(value = "/all")
	public List<Stagiaire> findStagiaire() {
		return stagiaireService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Stagiaire> findStagiaire(@PathVariable Long id) {
		return stagiaireService.findStagiaire(id);
		
	}
	
	@GetMapping(value = "/page")
	public Page<Stagiaire> showPage (@RequestParam(defaultValue="0") int page ) {
		return stagiaireRepository.findAll(new PageRequest(page,10));
		
	}
	
	@PostMapping()
	public Stagiaire addStagiaire(@RequestBody Stagiaire stagiaire) {
		stagiaireService.addStagiaire(stagiaire);
		return stagiaire;
	}
	
	@PutMapping()
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Stagiaire stagiaire) {
		stagiaire.setId(id);
		stagiaireService.updateStagiaire(stagiaire);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStagiaire(@PathVariable(name = "id") Long id) {
		stagiaireService.delete(id);
	}
	
	

}
