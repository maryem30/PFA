package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.InternshipInvalidRepository;
import com.stagiaires.stagiaire.entities.InternshipInvalid;

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

	public InternshipInvalid addInternshipInvalid(InternshipInvalid internshipInvalid) {
		return internshipRepository.saveAndFlush(internshipInvalid);
	}

	public void deleteInternshipInvalid(Long id) {
		Optional<InternshipInvalid> internshipInvalid = internshipRepository.findById(id);
		if (internshipInvalid != null)
			internshipRepository.delete(internshipInvalid.get());
	}

	public InternshipInvalid updateInternshipInvalid(InternshipInvalid internshipInvalid) {
		return internshipRepository.save(internshipInvalid);
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
