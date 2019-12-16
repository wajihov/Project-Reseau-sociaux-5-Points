package com.grokonez.jwtauthentication.service.Impl;

import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// test
import java.util.List;
import java.util.Optional;

@Component
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    // used in UpdateAccount ( encode the password again )
    @Autowired
    PasswordEncoder encoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return  userRepository.findUserById(userId);
    }
    public boolean getUserByUsername(String username) {
        return  userRepository.existsByUsername(username);
    }

    public User updateAccountUser(Long id,User user)
    {
        System.out.println("user = "+user.toString());
        User u = userRepository.findUserById(id);
        if(user.getPassword()!=null)
            u.setPassword(encoder.encode(user.getPassword()));
        if(user.isEnabled() || !user.isEnabled())
            u.setEnabled(user.isEnabled());
        if(user.getUsername() !=null)
            u.setUsername(user.getUsername());
        User updatedUser = userRepository.save(u);
        System.out.println("Updateduser = "+updatedUser.toString());
        return updatedUser ;
    }
}
