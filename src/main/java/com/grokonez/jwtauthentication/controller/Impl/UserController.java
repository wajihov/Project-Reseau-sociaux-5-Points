package com.grokonez.jwtauthentication.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.service.Impl.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok().body(userService.findAll());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
		User user = userService.getUserById(userId);
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/updateAccount/{id}")
	public ResponseEntity<User> updateAccountUser(@PathVariable(value = "id") Long userId,
			@RequestBody User userDetails) {
		if (userService.getUserByUsername(userDetails.getUsername()))
			return ResponseEntity.status(HttpStatus.IM_USED).body(userDetails);
		User user = userService.updateAccountUser(userId, userDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<User> updateProfileUser(@PathVariable(value = "id") Long userId,
			@RequestBody User userDetails) {
		User user = userService.updateProfile(userId, userDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

}
