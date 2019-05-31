package com.stagiaires.stagiaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stagiaires.stagiaire.entities.Internship;
@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long>{

}
