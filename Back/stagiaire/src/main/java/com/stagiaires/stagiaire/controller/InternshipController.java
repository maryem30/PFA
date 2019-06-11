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

import com.stagiaires.stagiaire.entities.Internship;
import com.stagiaires.stagiaire.services.InternshipService;

@CrossOrigin("*")
@RestController
@RequestMapping("/internship/")
public class InternshipController {
	private InternshipService internshipService;

	@Autowired
	public InternshipController(InternshipService internshipService) {
		super();
		this.internshipService = internshipService;
	}

	@GetMapping(value = "/all")
	public List<Internship> findInternship() {
		return internshipService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Internship> findInternship(@PathVariable Long id) {
		return internshipService.findInternship(id);
		
	}

	@PostMapping
	public void addInternship(@PathVariable(name = "id") Long id, @RequestBody Internship internship) {
		internship.setId(id);
		internshipService.addInternship(internship);
	}
	
	@PutMapping
	public void updateInternship(@PathVariable(name = "id") Long id, @RequestBody Internship internship) {
		internship.setId(id);
		internshipService.updateInternship(internship);
	}
	

	
	
	@DeleteMapping("/{id}")
	public void deleteInternship(@PathVariable(name = "id") Long id) {
		internshipService.delete(id);
	}
	
}
