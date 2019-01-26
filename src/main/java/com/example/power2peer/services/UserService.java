package com.example.power2peer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.power2peer.models.User;
import com.example.power2peer.repositories.UserRepository;

@RestController
@CrossOrigin(origins="*")
public class UserService {
	@Autowired
	UserRepository userRepository;
	@GetMapping("/api/users")
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	@GetMapping("/api/users/{id}")
	public User findUserById(@PathVariable("id") Integer id) {
		return userRepository.findUserById(id);
	}
	@PostMapping("/api/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	@DeleteMapping("/api/users/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	@PutMapping("/api/users/{id}")
	public User updateUser(
			@PathVariable("id") Integer id,
			@RequestBody User userUpdates) {
		User user = userRepository.findUserById(id);
		user.setFirstName(userUpdates.getFirstName());
		user.setLastName(userUpdates.getLastName());
		return userRepository.save(user);
	}
}
