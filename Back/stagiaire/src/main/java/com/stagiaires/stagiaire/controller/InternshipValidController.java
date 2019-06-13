package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.entities.InternshipValid;
import com.stagiaires.stagiaire.services.InternshipValidService;

@CrossOrigin("*")
@RestController
@RequestMapping("/internshipvalid/")
public class InternshipValidController {
	private InternshipValidService internshipService;

	@Autowired
	public InternshipValidController(InternshipValidService internshipService) {
		super();
		this.internshipService = internshipService;
	}

	@GetMapping(value = "/all")
	public List<InternshipValid> findInternshipValid() {
		return internshipService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<InternshipValid> findInternshipValid(@PathVariable Long id) {
		return internshipService.findInternshipValid(id);
		
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public InternshipValid addInternshipValid(@RequestBody InternshipValid internship) {
		internshipService.addInternshipValid(internship);
		return internship ;
	}
	
	@PutMapping
	public void updateInternshipValid(@PathVariable(name = "id") Long id, @RequestBody InternshipValid internship) {
		internship.setId(id);
		internshipService.updateInternshipValid(internship);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteInternshipValid(@PathVariable(name = "id") Long id) {
		internshipService.delete(id);
	}
	
}
