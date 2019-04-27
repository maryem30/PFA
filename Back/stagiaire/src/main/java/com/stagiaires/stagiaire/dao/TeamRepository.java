package com.stagiaires.stagiaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagiaires.stagiaire.entities.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
