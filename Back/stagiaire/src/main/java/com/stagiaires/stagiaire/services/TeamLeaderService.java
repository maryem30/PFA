package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.stagiaires.stagiaire.dao.TeamLeaderRepository;
import com.stagiaires.stagiaire.entities.TeamLeader;

@CrossOrigin("*")
@Service
@Transactional

public class TeamLeaderService {

	private TeamLeaderRepository teamLeaderRepository;

	@Autowired
	public TeamLeaderService(TeamLeaderRepository teamLeaderRepository) {
		super();
		this.teamLeaderRepository = teamLeaderRepository;
	}

	public TeamLeader addTeamLeader(TeamLeader s) {
		return teamLeaderRepository.saveAndFlush(s);
	}

	public void deleteTeamLeader(Long id) {
		Optional<TeamLeader> s = teamLeaderRepository.findById(id);
		if (s != null)
			teamLeaderRepository.delete(s.get());
	}

	public TeamLeader updateTeamLeader(TeamLeader s) {
		return teamLeaderRepository.save(s);
	}

	public Optional<TeamLeader> findTeamLeader(Long id) {
		return teamLeaderRepository.findById(id);
	}

	public List<TeamLeader> findAll() {
		return teamLeaderRepository.findAll();
	}

	public void delete(Long id) {
		teamLeaderRepository.deleteById(id);
	}
}
