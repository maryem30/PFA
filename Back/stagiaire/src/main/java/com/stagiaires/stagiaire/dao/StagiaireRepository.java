package com.stagiaires.stagiaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.entities.Stagiaire;
@CrossOrigin("*")
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
	

}
