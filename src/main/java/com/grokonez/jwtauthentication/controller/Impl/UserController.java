package com.grokonez.jwtauthentication.controller.Impl;

import com.grokonez.jwtauthentication.controller.interfaces.IUserController;
import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/")
public class UserController implements IUserController {
	@Autowired
	private UserService userService;

	// Récupérer la liste des users
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@PutMapping("/updateP/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userModify) {
		System.out.println("Hello dans Update");
		return ResponseEntity.ok(userService.updateProfile(userId, userModify));
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(value = "id") Long id) {
		return userService.getUser(id);
	}
}
