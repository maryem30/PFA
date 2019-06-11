package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.InternshipRepository;
import com.stagiaires.stagiaire.entities.Internship;

@CrossOrigin("*")
@Service
@Transactional
public class InternshipService {

	private InternshipRepository internshipRepository;

	@Autowired
	public InternshipService(InternshipRepository internshipRepository) {
		super();
		this.internshipRepository = internshipRepository;
	}

	public Internship addInternship(Internship internship) {
		return internshipRepository.saveAndFlush(internship);
	}

	public void deleteInternship(Long id) {
		Optional<Internship> internship = internshipRepository.findById(id);
		if (internship != null)
			internshipRepository.delete(internship.get());
	}

	public Internship updateInternship(Internship internship) {
		return internshipRepository.save(internship);
	}

	public Optional<Internship> findInternship(Long id) {
		return internshipRepository.findById(id);
	}

	public List<Internship> findAll() {
		return internshipRepository.findAll();
	}

	public void delete(Long id) {
		internshipRepository.deleteById(id);
		
	}

}
