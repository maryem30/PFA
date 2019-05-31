package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.LeaveRepository;
import com.stagiaires.stagiaire.entities.Leave;

@CrossOrigin("*")
@Service
@Transactional
public class LeaveService {

	private LeaveRepository leaveRepository;

	@Autowired
	public LeaveService(LeaveRepository leaveRepository) {
		super();
		this.leaveRepository = leaveRepository;
	}

	public Leave addLeave(Leave s) {
		return leaveRepository.saveAndFlush(s);
	}

	public void deleteLeave(Long id) {
		Optional<Leave> s = leaveRepository.findById(id);
		if (s != null)
			leaveRepository.delete(s.get());
	}

	public Leave updateLeave(Leave s) {
		return leaveRepository.save(s);
	}

	public Optional<Leave> findLeave(Long id) {
		return leaveRepository.findById(id);
	}

	public List<Leave> findAll() {
		return leaveRepository.findAll();
	}

	public void delete(Long id) {
		leaveRepository.deleteById(id);
		
	}

}
