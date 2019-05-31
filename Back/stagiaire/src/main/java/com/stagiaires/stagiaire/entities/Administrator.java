package com.stagiaires.stagiaire.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
@DiscriminatorValue("admin")
@PrimaryKeyJoinColumn(name = "id")

public class Administrator extends User {

	private static final long serialVersionUID = 1L;

	private String role;
	private String tel;

	public Administrator() {
		super();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
