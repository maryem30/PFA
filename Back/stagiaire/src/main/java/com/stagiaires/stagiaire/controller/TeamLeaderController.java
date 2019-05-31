package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.entities.TeamLeader;
import com.stagiaires.stagiaire.services.TeamLeaderService;
@CrossOrigin("*")
@RestController
@RequestMapping("/teamLeaders/")
public class TeamLeaderController {
	
	private TeamLeaderService teamLeaderService;

	@Autowired
	public TeamLeaderController(TeamLeaderService teamLeaderService) {
		super();
		this.teamLeaderService = teamLeaderService;
	}

	@GetMapping(value = "/all")
	public List<TeamLeader> findTeamLeader() {
		return teamLeaderService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<TeamLeader> findTeamLeader(@PathVariable Long id) {
		return teamLeaderService.findTeamLeader(id);
		
	}

	@RequestMapping( value="/deleteTeamLeader{id}", method = RequestMethod.DELETE)
	public void deleteTeamLeader(@PathVariable(name = "id") Long id) {
		teamLeaderService.delete(id);

	}

	@RequestMapping(value = "/teamLeader/{id}", method = RequestMethod.PUT)
	public TeamLeader updateTeamLeader(@PathVariable(name = "id") Long id, @RequestBody TeamLeader teamLeader) {
		teamLeader.setId(id);
		return teamLeaderService.addTeamLeader(teamLeader);
	}
	

}
