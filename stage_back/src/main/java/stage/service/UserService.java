package stage.service;

import java.util.List;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;



import stage.dao.UserRepository;
import stage.entities.user;

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

	public user addUser(user user) {
		userRepository.save(user);
		System.out.println("ajouter");

		return user;

	}

	public void deleteUser(Long id) {
		Optional<user> user = userRepository.findById(id);
		if (user != null)
			userRepository.delete(user.get());
	}

	public void updateUser(user user) {

		userRepository.save(user);
		System.out.println("modifier");

	}

	public Optional<user> findUser(Long id) {
		return userRepository.findById(id);
	}

	public List<user> findAll() {
		return userRepository.findAll();
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

}
