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

	public TeamLeader addTeamLeader(TeamLeader teamLeader) {
		return teamLeaderRepository.saveAndFlush(teamLeader);
	}

	public void deleteTeamLeader(Long id) {
		Optional<TeamLeader> teamLeader = teamLeaderRepository.findById(id);
		if (teamLeader != null)
			teamLeaderRepository.delete(teamLeader.get());
	}

	public TeamLeader updateTeamLeader(TeamLeader teamLeader) {
		return teamLeaderRepository.save(teamLeader);
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
