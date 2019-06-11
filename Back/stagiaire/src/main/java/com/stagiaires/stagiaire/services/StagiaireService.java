package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

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

	public Stagiaire addStagiaire(Stagiaire s) {
		stagiaireRepository.save(s);
		System.out.println("ajouter");

		return s;
	}

	public void deleteStagiaire(Long id) {
		Optional<Stagiaire> s = stagiaireRepository.findById(id);
		if (s != null)
			stagiaireRepository.delete(s.get());
	}

	public void updateStagiaire(Stagiaire s) {
		stagiaireRepository.delete(s);
		stagiaireRepository.save(s);
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
