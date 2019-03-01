package com.stagiaires.stagiaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagiaires.stagiaire.entities.Stagiaire;
@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {

}
