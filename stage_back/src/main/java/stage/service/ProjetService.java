package stage.service;

import java.util.List;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;



import stage.dao.ProjetRepository;
import stage.entities.projet;


@CrossOrigin("*")
@Service
@Transactional

public class ProjetService {
	
	private ProjetRepository projetRepository;

	@Autowired
	public ProjetService(ProjetRepository projetRepository) {
		super();
		this.projetRepository = projetRepository;
	}

	public projet addProjet(projet projet) {
		projetRepository.save(projet);
		System.out.println("ajouter");

		return projet;

	}

	public void deleteProjet(Long id) {
		Optional<projet> projet = projetRepository.findById(id);
		if (projet != null)
			projetRepository.delete(projet.get());
	}

	public void updateProjet(projet projet) {

		projetRepository.save(projet);
		System.out.println("modifier");

	}

	public Optional<projet> findProjet(Long id) {
		return projetRepository.findById(id);
	}

	public List<projet> findAll() {
		return projetRepository.findAll();
	}

	public void delete(Long id) {
		projetRepository.deleteById(id);
		
	}

}
