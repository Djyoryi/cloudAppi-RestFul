package com.proyect.cloudappirestful.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.cloudappirestful.entity.User;
import com.proyect.cloudappirestful.service.UsersService;

@RestController
@RequestMapping("users")
public class UsersRest {

	@Autowired
	private UsersService usersService;

	@GetMapping
	public ResponseEntity<List<User>> getUser() {
		List<User> users = usersService.findAll();
		return ResponseEntity.ok(users);

	}

	@RequestMapping(value = "{userId}") // /users/{userId} -> /users/1
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
		Optional<User> optionalProduct = usersService.findById(userId);
		if (optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	@PostMapping // /users (POST)
	public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
		User newUser = usersService.save(user);
		return ResponseEntity.ok(newUser);

	}

	@PutMapping(value = "{userId}") // /users/{userId} -> /users/1 (el 1 es un ejemplo de lo que quieras updatear))
	public ResponseEntity<User> updateUserById(@PathVariable("userId") Integer userId, @RequestBody User user) {
		Optional<User> optionalUser = usersService.findById(userId);
		if (optionalUser.isPresent()) {
			User updateUser = optionalUser.get();
			updateUser.setName(user.getName());
			updateUser.setEmail(user.getEmail());
			updateUser.setBirthDate(user.getBirthDate());
			updateUser.setAddress(user.getAddress());
			usersService.save(updateUser);
			return ResponseEntity.ok(updateUser);
		} else {
			return ResponseEntity.notFound().build();

		}

	}

	@DeleteMapping(value = "{userId}") // /users/{userId} -> /users/1 (el 1 es un ejemplo de lo que quieras borrar))
	public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Integer userId) {
		usersService.deleteById(userId);
		return ResponseEntity.ok(null);

	}
}
