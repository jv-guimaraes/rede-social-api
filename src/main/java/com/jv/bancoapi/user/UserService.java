package com.jv.bancoapi.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Usuario> getAllUsers() {
		List<Usuario> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public Usuario getUser(String id) {
		return userRepository.findById(id).orElse(null);
	}

	public void addUser(Usuario user) {
		userRepository.save(user);
	}

	public void updateUser(Usuario user) {
		userRepository.save(user);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
	
}
