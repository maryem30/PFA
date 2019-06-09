package com.stagiaires.stagiaire.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	public Internship addInternship(Internship s) {
		return internshipRepository.saveAndFlush(s);
	}

	public void deleteInternship(Long id) {
		Optional<Internship> s = internshipRepository.findById(id);
		if (s != null)
			internshipRepository.delete(s.get());
	}

	public Internship updateInternship(Internship s) {
		return internshipRepository.save(s);
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
	
	@Autowired
	public List<Map<String, Object>> report(){
		List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
		for(Internship internship : this.findAll()) {
			Map<String, Object> item=new HashMap<String, Object>();
			item.put("id", internship.getId());
			item.put("nom", internship.getStagiaire().getNom());
			item.put("prenom", internship.getStagiaire().getPrenom());
			result.add(item);
		}
		return result; 
	}

}
