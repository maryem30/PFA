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



import stage.dao.ProjetRepository;
import stage.entities.projet;
import stage.service.ProjetService;


@CrossOrigin("*")
@RestController

@RequestMapping("/projet/")
public class ProjetController {
	
	
	private ProjetService projetService;
	
	@Autowired
	private ProjetRepository projetRepository;

	@Autowired
	public ProjetController(ProjetService projetService) {
		super();
		this.projetService = projetService;
	}

	@GetMapping(value = "/all")
	public List<projet> findProjet() {
		return projetService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<projet> findProjet(@PathVariable Long id) {
		return projetService.findProjet(id);
		
	}

	
	@GetMapping(value = "/page")

	public Page<projet> showPage(@RequestParam(defaultValue = "1") int page) {
		return projetRepository.findAll(new PageRequest(page, 10));

	}
	
	
	
	@PostMapping(value ="/{id}")
	public void addProjet(@PathVariable(name = "id") Long id, @RequestBody projet projet) {
		projet.setId(id);
		projetService.addProjet(projet);
	}
	
	@PutMapping("/{id}")
	public void updateProjet(@PathVariable(name = "id") Long id, @RequestBody projet projet) {
		projet.setId(id);
		projetService.updateProjet(projet);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteProjet(@PathVariable(name = "id") Long id) {
		projetService.delete(id);
	}
	

}
