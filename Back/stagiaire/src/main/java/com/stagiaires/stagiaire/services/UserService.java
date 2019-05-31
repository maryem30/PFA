package com.stagiaires.stagiaire.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stagiaires.stagiaire.dao.UserRepository;
import com.stagiaires.stagiaire.entities.User;

@CrossOrigin("*")
@Service
@Transactional
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User addUser(User s) {
		return userRepository.saveAndFlush(s);
	}

	public void deleteUser(Long id) {
		Optional<User> s = userRepository.findById(id);
		if (s != null)
			userRepository.delete(s.get());
	}

	public User updateUser(User s) {
		return userRepository.save(s);
	}

	public Optional<User> findUser(Long id) {
		return userRepository.findById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

}
