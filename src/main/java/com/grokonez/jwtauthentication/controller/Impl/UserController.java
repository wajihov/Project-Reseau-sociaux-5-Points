package com.grokonez.jwtauthentication.controller.Impl;


import com.grokonez.jwtauthentication.controller.interfaces.IUserController;
import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/")
public class UserController implements IUserController {
    @Autowired
    private UserService userService;

    //Récupérer la liste des users
    @RequestMapping(value="/getAll", method= RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
