package com.stagiaires.stagiaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.entities.Stagiaire;
import com.stagiaires.stagiaire.services.StagiaireService;
@CrossOrigin("*")
@RestController
@RequestMapping("/stagiaires/")
public class StagiaireController {
	
	private StagiaireService stagiaireService;

	@Autowired
	public StagiaireController(StagiaireService stagiaireService) {
		super();
		this.stagiaireService = stagiaireService;
	}

	@GetMapping(value = "/all")
	public List<Stagiaire> findStagiaire() {
		return stagiaireService.findAll();
	}

	@RequestMapping(value = "/stagiaires/{id}", method = RequestMethod.GET)
	public Stagiaire findStagiairebyId(@PathVariable Long id) {
		Stagiaire s = stagiaireService.findStagiaire(id);
		return s;
	}

	@RequestMapping(value = "/deleteStagiaire/{id}", method = RequestMethod.DELETE)
	public void deleteStagiaire(@PathVariable(name = "id") Long id) {
		stagiaireService.delete(id);

	}

	@RequestMapping(value = "/stagiaire/{id}", method = RequestMethod.PUT)
	public Stagiaire updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Stagiaire stagiaire) {
		stagiaire.setId(id);
		return stagiaireService.addStagiaire(stagiaire);
	}

}
