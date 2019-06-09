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

import com.stagiaires.stagiaire.entities.InternshipInvalid;
import com.stagiaires.stagiaire.services.InternshipInvalidService;

@CrossOrigin("*")
@RestController
@RequestMapping("/internshipinvalid/")
public class InternshipInvalidController {
	private InternshipInvalidService internshipService;

	@Autowired
	public InternshipInvalidController(InternshipInvalidService internshipService) {
		super();
		this.internshipService = internshipService;
	}

	@GetMapping(value = "/all")
	public List<InternshipInvalid> findInternshipInvalid() {
		return internshipService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<InternshipInvalid> findInternshipInvalid(@PathVariable Long id) {
		return internshipService.findInternshipInvalid(id);
		
	}

	@PostMapping
	public void addInternshipInvalid(@PathVariable(name = "id") Long id, @RequestBody InternshipInvalid internship) {
		internship.setId(id);
		internshipService.addInternshipInvalid(internship);
	}
	
	@PutMapping
	public void updateInternshipInvalid(@PathVariable(name = "id") Long id, @RequestBody InternshipInvalid internship) {
		internship.setId(id);
		internshipService.updateInternshipInvalid(internship);
	}

	@DeleteMapping("/{id}")
	public void deleteInternshipInvalid(@PathVariable(name = "id") Long id) {
		internshipService.delete(id);
	}
	
}
