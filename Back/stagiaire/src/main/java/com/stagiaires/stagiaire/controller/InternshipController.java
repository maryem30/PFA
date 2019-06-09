package com.stagiaires.stagiaire.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.stagiaires.stagiaire.entities.Internship;
import com.stagiaires.stagiaire.services.InternshipService;


@CrossOrigin("*")
@RestController
@RequestMapping("/internship/")
public class InternshipController {
	private InternshipService internshipService;
	
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
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
	public void addStagiaire(@PathVariable(name = "id") Long id, @RequestBody Internship internship) {
		internship.setId(id);
		internshipService.addInternship(internship);
	}
	
	@PutMapping
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Internship internship) {
		internship.setId(id);
		internshipService.updateInternship(internship);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteInternship(@PathVariable(name = "id") Long id) {
		internshipService.delete(id);
	}
	
	@GetMapping(value = "/pdf")
	public ModelAndView attestation() {
		
		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:/reports/report.jxml");
		view.setApplicationContext(applicationContext);
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("datasource", internshipService.report());
		return new ModelAndView(view,params);
		
	}
}
