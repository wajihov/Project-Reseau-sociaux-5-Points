package com.fivePoints.dao;

import java.util.List;

import com.fivePoints.entities.User;

public interface IUserService {

	public User updateProfile(Long id, User u);

	public List<User> findAll();

	public User getUserById(Long id);

	public boolean getUserByUsername(String username);

	public User updateAccountUser(Long id, User user);
	
	public User getUserConnect(String username);

}
