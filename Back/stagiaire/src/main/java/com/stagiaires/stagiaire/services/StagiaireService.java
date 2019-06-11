package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.StagiaireRepository;
import com.stagiaires.stagiaire.entities.Stagiaire;

@CrossOrigin("*")
@Service
@Transactional
public class StagiaireService {

	private StagiaireRepository stagiaireRepository;

	@Autowired
	public StagiaireService(StagiaireRepository stagiaireRepository) {
		super();
		this.stagiaireRepository = stagiaireRepository;
	}


	public Stagiaire addStagiaire(Stagiaire stagiaire) {
		stagiaireRepository.save(stagiaire);
		System.out.println("ajouter");

		return stagiaire;

	}

	public void deleteStagiaire(Long id) {
		Optional<Stagiaire> stagiaire = stagiaireRepository.findById(id);
		if (stagiaire != null)
			stagiaireRepository.delete(stagiaire.get());
	}

	public void updateStagiaire(Stagiaire stagiaire) {
		stagiaireRepository.delete(stagiaire);
		stagiaireRepository.save(stagiaire);
		System.out.println("modifier");

	}

	public Optional<Stagiaire> findStagiaire(Long id) {
		return stagiaireRepository.findById(id);
	}

	public List<Stagiaire> findAll() {
		return stagiaireRepository.findAll();
	}

	public void delete(Long id) {
		stagiaireRepository.deleteById(id);

	}

}
