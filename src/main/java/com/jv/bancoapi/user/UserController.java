package com.jv.bancoapi.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<Usuario> gelAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Usuario getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody Usuario user) {
		userService.addUser(user);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody Usuario user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
