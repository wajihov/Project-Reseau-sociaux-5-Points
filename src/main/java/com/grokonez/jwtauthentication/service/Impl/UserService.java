package com.grokonez.jwtauthentication.service.Impl;

import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// test
import java.util.List;

@Component
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User updateProfile(Long id, User u) {
		User user = userRepository.findById(id).get();
		System.out.println("Dans Update " + user.getUsername());
		try {
			user.setBirthdate(u.getBirthdate());
			user.setDescription(u.getDescription());
			user.setEyesColor(u.getEyesColor());
			user.setGender(u.getGender());
			user.setHairColor(u.getHairColor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		User UpdateUser = userRepository.save(user);
		return UpdateUser;
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
}
