package com.jv.bancoapi.user;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private HashMap<String, User> users = new HashMap<>();
	
	public UserService() {
		users.put("iven", new User("iven", "Iven", "Estudante de medicina."));
		users.put("maria", new User("maria", "Maria", "Olá! Sou uma estudande de emfermagem."));
	}
	
	public HashMap<String, User> getAllUsers() {
		return users;
	}
	
	public User getUser(String id) {
		return users.get(id);
	}

	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	public void updateUser(String id, User user) {
		users.put(id, user);
	}

	public void deleteUser(String id) {
		users.remove(id);
	}
	
}
