package com.stagiaires.stagiaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.entities.User;

@CrossOrigin("*")
public interface UserRepository extends JpaRepository<User, Long>{

}
