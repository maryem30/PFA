package com.stagiaires.stagiaire.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
@DiscriminatorValue("True")
@PrimaryKeyJoinColumn(name = "id")
public class InternshipValid extends Internship{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
