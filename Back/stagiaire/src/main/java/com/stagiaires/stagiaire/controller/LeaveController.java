package com.stagiaires.stagiaire.controller;

import java.util.List;
import java.util.Optional;

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

import com.stagiaires.stagiaire.entities.Leave;
import com.stagiaires.stagiaire.services.LeaveService;

@CrossOrigin("*")
@RestController
@RequestMapping("/leave/")
public class LeaveController {
	private LeaveService leaveService;

	@Autowired
	public LeaveController(LeaveService leaveService) {
		super();
		this.leaveService = leaveService;
	}

	@GetMapping(value = "/all")
	public List<Leave> findLeave() {
		return leaveService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Leave> findLeave(@PathVariable Long id) {
		return leaveService.findLeave(id);

	}

	@PostMapping
	public void addStagiaire(@PathVariable(name = "id") Long id, @RequestBody Leave leave) {
		leave.setId(id);
		leaveService.addLeave(leave);
	}

	@PutMapping
	public void updateStagiaire(@PathVariable(name = "id") Long id, @RequestBody Leave leave) {
		leave.setId(id);
		leaveService.updateLeave(leave);
	}

	@DeleteMapping("/{id}")
	public void deleteLeave(@PathVariable(name = "id") Long id) {
		leaveService.delete(id);
	}

}
