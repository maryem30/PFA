package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.InternshipValidRepository;
import com.stagiaires.stagiaire.entities.InternshipValid;

@CrossOrigin("*")
@Service
@Transactional
public class InternshipValidService {

	private InternshipValidRepository internshipValidRepository;

	@Autowired
	public InternshipValidService(InternshipValidRepository internshipValidRepository) {
		super();
		this.internshipValidRepository = internshipValidRepository;
	}

	public InternshipValid addInternshipValid(InternshipValid s) {
		return internshipValidRepository.saveAndFlush(s);
	}

	public void deleteInternshipValid(Long id) {
		Optional<InternshipValid> s = internshipValidRepository.findById(id);
		if (s != null)
			internshipValidRepository.delete(s.get());
	}

	public InternshipValid updateInternshipValid(InternshipValid s) {
		return internshipValidRepository.save(s);
	}

	public Optional<InternshipValid> findInternshipValid(Long id) {
		return internshipValidRepository.findById(id);
	}

	public List<InternshipValid> findAll() {
		return internshipValidRepository.findAll();
	}

	public void delete(Long id) {
		internshipValidRepository.deleteById(id);
		
	}

}
