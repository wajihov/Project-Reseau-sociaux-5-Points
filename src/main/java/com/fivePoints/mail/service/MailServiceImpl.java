package com.fivePoints.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fivePoints.dao.UserService;
import com.fivePoints.entities.User;
import com.fivePoints.security.domaine.UserRepository;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userservice;

	@Override
	public User getUserByMail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User resetPassword(Long id, User u) {
		User userUpdate = userservice.updateAccountUser(id, u);
		return userUpdate;
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findUserById(id);
	}

}
