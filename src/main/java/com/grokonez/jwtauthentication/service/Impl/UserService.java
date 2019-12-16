package com.grokonez.jwtauthentication.service.Impl;

import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

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
		User u = userRepository.findUserById(id);
		u.setPassword(encoder.encode(user.getPassword()));
		User updatedUser = userRepository.save(u);
		return updatedUser;
	}

}
