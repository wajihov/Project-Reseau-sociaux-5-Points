package com.fivePoints.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivePoints.dao.UserService;
import com.fivePoints.entities.User;
import com.fivePoints.security.domaine.UserRepository;
import com.fivePoints.services.LoginForm;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users/")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

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
		
		
		
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		String jwt = jwtProvider.generateJwtToken(authentication);
//		String user = jwtProvider.generateJwtTokenUser(authentication);
//		return ResponseEntity.ok(new JwtResponse(jwt, user));

		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<User> updateProfileUser(@PathVariable(value = "id") Long userId,
			@RequestBody User userDetails) {
		User user = userService.updateProfile(userId, userDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}

	@GetMapping("/getUser/{usernameConnected}")
	public Optional<User> getUser(@PathVariable(value = "usernameConnected") String username) {
		System.out.println("hello dans GetUsername : " + username);
		Optional<User> u = userRepository.findByUsername(username);
		if (u != null)
			return u;
		else
			return null;
	}

	@PostMapping("/majUsername")
	public Long existUsername(@RequestBody LoginForm loginRequest) {
		System.out.println("username : " + loginRequest.getUsername());
		if (userService.getUserByUsername(loginRequest.getUsername())) {
			User u = userService.getUserConnect(loginRequest.getUsername());
			return u.getId();
		} else
			return 0L;
	}

	@PostMapping("/majEmail")
	public Long existMail(@RequestBody LoginForm email) {
		if (userRepository.existsByEmail(email.getEmail())) {
			// User u = userService.getUserConnect(username.getUsername());
			User u = userRepository.findByEmail(email.getEmail());			
			return u.getId();
		} else
			return 0L;
	}

//	@PostMapping("/userEmail")
//	public User getUserByEmail(@RequestBody String email) {
//		if (userRepository.existsByEmail(email)) {
//			return userRepository.findByEmail(email);
//		} else
//			return null;
//	}

}
