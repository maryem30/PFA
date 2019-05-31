package com.stagiaires.stagiaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stagiaires.stagiaire.entities.Leave;
@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{

}
