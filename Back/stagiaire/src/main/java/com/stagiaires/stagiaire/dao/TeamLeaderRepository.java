package com.stagiaires.stagiaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.stagiaires.stagiaire.entities.TeamLeader;

@CrossOrigin("*")
public interface TeamLeaderRepository extends JpaRepository<TeamLeader, Long> {

}
