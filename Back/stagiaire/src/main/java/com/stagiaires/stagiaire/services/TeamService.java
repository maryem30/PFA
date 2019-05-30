package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stagiaires.stagiaire.dao.TeamRepository;
import com.stagiaires.stagiaire.entities.Stagiaire;
import com.stagiaires.stagiaire.entities.Team;

@Service
public class TeamService {
	
	private TeamRepository teamRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}
	
	public Team addTeam(Team team) {
		return teamRepository.saveAndFlush(team);
	}

	public void deleteTeam(Long id) {
		Optional<Team> team = teamRepository.findById(id);
		if (team != null)
			teamRepository.delete(team.get());
	}
	public Team updateTeam(Team team) {
		return teamRepository.save(team);
	}

	public Optional<Team> findTeam(Long id) {
		return teamRepository.findById(id);
	}

	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	public void delete(Long id) {
		teamRepository.deleteById(id);
		
	}



}
