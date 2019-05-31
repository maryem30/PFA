package com.stagiaires.stagiaire.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
@DiscriminatorValue("scrum")
@PrimaryKeyJoinColumn(name = "id")
public class TeamLeader extends User{

	private static final long serialVersionUID = 1L;

	/*@OneToOne(cascade = CascadeType.ALL)
	private Team team;*/
	private String tel;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	/*public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}*/
}
