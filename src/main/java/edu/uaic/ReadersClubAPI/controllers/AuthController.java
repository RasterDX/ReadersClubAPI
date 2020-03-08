package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("auth/login")
    String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        return authService.login(email, password);
    }
}
