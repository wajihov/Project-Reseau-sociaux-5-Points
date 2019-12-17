package com.grokonez.jwtauthentication.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.service.interfaces.IUserService;

@Component
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User updateProfile(Long id, User u) {
		User user = userRepository.findById(id).get();
		try {
			if (u.getDescription() != null)
				user.setDescription(u.getDescription());
			if (u.getBirthdate() != null)
				user.setBirthdate(u.getBirthdate());
			if (u.getEyesColor() != null)
				user.setEyesColor(u.getEyesColor());
			if (u.getGender() != null)
				user.setGender(u.getGender());
			if (u.getHairColor() != null)
				user.setHairColor(u.getHairColor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		User UpdateUser = userRepository.save(user);
		return UpdateUser;
	}

	// used in UpdateAccount ( encode the password again )
	@Autowired
	PasswordEncoder encoder;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User getUserById(Long userId) {
		return userRepository.findUserById(userId);
	}

	public boolean getUserByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public User updateAccountUser(Long id, User user) {
		System.out.println("user = " + user.toString());
		User u = userRepository.findUserById(id);
		if (user.getPassword() != null)
			u.setPassword(encoder.encode(user.getPassword()));
		if (user.isEnabled() || !user.isEnabled())
			u.setEnabled(user.isEnabled());
		if (user.getUsername() != null)
			u.setUsername(user.getUsername());
		User updatedUser = userRepository.save(u);
		System.out.println("Updateduser = " + updatedUser.toString());
		return updatedUser;
	}

	@Override
	public User getUserConnect(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		return user;
	}

}
