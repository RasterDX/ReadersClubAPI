package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.models.User;
import edu.uaic.ReadersClubAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    User postUser(@RequestBody User userToAdd) {
        return userService.saveUser(userToAdd);
    }

    @GetMapping("user/{id}")
    User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("user/all")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
