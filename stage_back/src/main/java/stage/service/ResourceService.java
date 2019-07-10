package stage.service;

import java.util.List;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;



import stage.dao.ResourceRepository;
import stage.entities.resource;


@CrossOrigin("*")
@Service
@Transactional

public class ResourceService {
	
	private ResourceRepository resourceRepository;

	@Autowired
	public ResourceService(ResourceRepository resourceRepository) {
		super();
		this.resourceRepository = resourceRepository;
	}

	public resource addResource(resource resource) {
		resourceRepository.save(resource);
		System.out.println("ajouter");

		return resource;

	}

	public void deleteResource(Long id) {
		Optional<resource> resource = resourceRepository.findById(id);
		if (resource != null)
			resourceRepository.delete(resource.get());
	}

	public void updateResource(resource resource) {

		resourceRepository.save(resource);
		System.out.println("modifier");

	}

	public Optional<resource> findResource(Long id) {
		return resourceRepository.findById(id);
	}

	public List<resource> findAll() {
		return resourceRepository.findAll();
	}

	public void delete(Long id) {
		resourceRepository.deleteById(id);
		
	}

}
