package com.stagiaires.stagiaire.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
@DiscriminatorValue("stagiaire")
@PrimaryKeyJoinColumn(name = "id")

public class Stagiaire extends User {

	private static final long serialVersionUID = 1L;



	private String tel;

	public Stagiaire() {
		super();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
