package com.fivePoints.security;

import com.fivePoints.dao.UserService;
import com.fivePoints.entities.User;
import com.fivePoints.security.domaine.RoleRepository;
import com.fivePoints.security.domaine.UserRepository;
import com.fivePoints.security.entities.Role;
import com.fivePoints.security.entities.RoleName;
import com.fivePoints.security.jwt.JwtProvider;
import com.fivePoints.security.jwt.JwtResponse;
import com.fivePoints.services.LoginForm;
import com.fivePoints.services.SignUpForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth/")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		System.out.println("authentification : " + loginRequest.getUsername() + " " + loginRequest.getPassword());

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		// String user = jwtProvider.generateJwtTokenUser(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@PostMapping("/username")
	public Boolean existUsername(@RequestBody LoginForm loginRequest) {
		// if (userRepository.existsByUsername(loginRequest.getUsername()))
		if (userService.getUserByUsername(loginRequest.getUsername()))
			return true;
		else
			return false;
	}

	@PostMapping("/email")
	public Boolean existMail(@RequestBody LoginForm loginForm) {
		if (userRepository.existsByEmail(loginForm.getEmail()))
			return true;
		else
			return false;
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		/*
		 * User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
		 * signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
		 */

		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getGender(), signUpRequest.getDescription(),
				signUpRequest.getHairColor(), signUpRequest.getEyesColor(), signUpRequest.getBirthdate());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles != null) {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(adminRole);

					break;
				case "pm":
					Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(pmRole);

					break;
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(userRole);
				}
			});
		} else {
			Role userDefaultRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userDefaultRole);
		}

		user.setEnabled(true);
		user.setBlocked(false);
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok().body("User registered successfully!");
	}
}