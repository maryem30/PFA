package com.stagiaires.stagiaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagiaires.stagiaire.entities.Team;
import com.stagiaires.stagiaire.services.TeamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/team/")
public class TeamContoller {

	private TeamService teamService;

	@Autowired
	public TeamContoller(TeamService teamService) {
		super();
		this.teamService = teamService;
	}

	@GetMapping(value = "/all")
	public List<Team> findTeam() {
		return teamService.findAll();
	}

	/*
	 * @GetMapping(value = "/{id}") public Optional<Team> findTeam(@PathVariable
	 * Long id) { return TeamService.findTeam(id);
	 * 
	 * }
	 */

	@PostMapping
	public void addStagiaire(@PathVariable(name = "id") Long id, @RequestBody Team team) {
		team.setId(id);
		teamService.addTeam(team);
	}

	@PutMapping
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Team team) {
		team.setId(id);
		teamService.updateTeam(team);
	}

	@DeleteMapping("/{id}")
	public void deleteTeam(@PathVariable(name = "id") Long id) {
		teamService.delete(id);
	}

}
