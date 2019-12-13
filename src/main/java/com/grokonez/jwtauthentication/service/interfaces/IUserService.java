package com.grokonez.jwtauthentication.service.interfaces;

import com.grokonez.jwtauthentication.model.user.User;

import java.util.List;

public interface IUserService {

	public List<User> findAll();

	public User updateProfile(Long id, User u);

	public User getUser(Long id);

}
