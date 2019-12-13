package com.grokonez.jwtauthentication.controller.Impl;


import com.grokonez.jwtauthentication.controller.interfaces.IUserController;
import com.grokonez.jwtauthentication.model.user.User;
import com.grokonez.jwtauthentication.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/")
public class UserController implements IUserController {
    @Autowired
    private UserService userService;

    //Récupérer la liste des users
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
    {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<User> updateAccountUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails)
    {
        if (userService.getUserByUsername(userDetails.getUsername()))
            return ResponseEntity.status(HttpStatus.IM_USED).body(userDetails);
        User user = userService.updateAccountUser(userId,userDetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }
}
