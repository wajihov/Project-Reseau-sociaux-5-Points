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
        return null;
    }
}
