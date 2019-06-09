package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.InternshipInvalidRepository;
import com.stagiaires.stagiaire.entities.InternshipInvalid;
import com.stagiaires.stagiaire.entities.InternshipValid;

@CrossOrigin("*")
@Service
@Transactional
public class InternshipInvalidService {

	private InternshipInvalidRepository internshipRepository;

	@Autowired
	public InternshipInvalidService(InternshipInvalidRepository internshipRepository) {
		super();
		this.internshipRepository = internshipRepository;
	}

	public InternshipInvalid addInternshipInvalid(InternshipInvalid s) {
		return internshipRepository.saveAndFlush(s);
	}

	public void deleteInternshipInvalid(Long id) {
		Optional<InternshipInvalid> s = internshipRepository.findById(id);
		if (s != null)
			internshipRepository.delete(s.get());
	}

	public InternshipInvalid updateInternshipInvalid(InternshipInvalid s) {
		return internshipRepository.save(s);
	}	

	public Optional<InternshipInvalid> findInternshipInvalid(Long id) {
		return internshipRepository.findById(id);
	}

	public List<InternshipInvalid> findAll() {
		return internshipRepository.findAll();
	}

	public void delete(Long id) {
		internshipRepository.deleteById(id);
		
	}

}
