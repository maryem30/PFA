package com.stagiaires.stagiaire.services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.AdministratorRepository;
import com.stagiaires.stagiaire.entities.Administrator;

@CrossOrigin("*")
@Service
@Transactional
public class AdministratorService {

	private AdministratorRepository administratorRepository;

	@Autowired
	public AdministratorService(AdministratorRepository administratorRepository) {
		super();
		this.administratorRepository = administratorRepository;
	}

	public Administrator addAdministrator(Administrator s) {
		return administratorRepository.saveAndFlush(s);
	}

	public void deleteAdministrator(Long id) {
		Optional<Administrator> s = administratorRepository.findById(id);
		if (s != null)
			administratorRepository.delete(s.get());
	}

	public Administrator updateAdministrator(Administrator s) {
		return administratorRepository.save(s);
	}

	public Optional<Administrator> findAdministrator(Long id) {
		return administratorRepository.findById(id);
	}

	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	public void delete(Long id) {
		administratorRepository.deleteById(id);
		
	}

}
