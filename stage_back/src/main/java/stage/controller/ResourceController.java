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





import stage.dao.ResourceRepository;
import stage.entities.resource;
import stage.service.ResourceService;


@CrossOrigin("*")
@RestController

@RequestMapping("/resource/")
public class ResourceController {
	
	
	private ResourceService resourceService;
	
	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	public ResourceController(ResourceService resourceService) {
		super();
		this.resourceService = resourceService;
	}

	@GetMapping(value = "/all")
	public List<resource> findResource() {
		return resourceService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<resource> findResource(@PathVariable Long id) {
		return resourceService.findResource(id);
		
	}

	
	@GetMapping(value = "/page")

	public Page<resource> showPage(@RequestParam(defaultValue = "1") int page) {
		return resourceRepository.findAll(new PageRequest(page, 10));

	}
	
	
	
	@PostMapping(value ="/{id}")
	public void addResource(@PathVariable(name = "id") Long id, @RequestBody resource resource) {
		resource.setId(id);
		resourceService.addResource(resource);
	}
	
	@PutMapping("/{id}")
	public void updateResource(@PathVariable(name = "id") Long id, @RequestBody resource resource) {
		resource.setId(id);
		resourceService.updateResource(resource);
	}
	
	@DeleteMapping("/{id}")
	public void  deleteResource(@PathVariable(name = "id") Long id) {
		resourceService.delete(id);
	}
	

}
