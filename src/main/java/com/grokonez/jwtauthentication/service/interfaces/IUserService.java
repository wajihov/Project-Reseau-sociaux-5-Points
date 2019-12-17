package com.grokonez.jwtauthentication.service.interfaces;

import com.grokonez.jwtauthentication.model.user.User;

import java.util.List;

public interface IUserService {

	public User updateProfile(Long id, User u);

	public List<User> findAll();

	public User getUserById(Long id);

	public boolean getUserByUsername(String username);

	public User updateAccountUser(Long id, User user);
	
	public User getUserConnect(String username);

}
