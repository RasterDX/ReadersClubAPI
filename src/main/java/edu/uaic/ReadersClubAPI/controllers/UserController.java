package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    UserModel postUser(@RequestBody UserModel userToAdd) {
        return userService.saveUser(userToAdd);
    }

    @GetMapping("user/{id}")
    UserModel getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("user/all")
    List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("user/books")
    void postBook(@RequestParam(name = "token") String token,
                  @RequestParam(name = "bookId") Long bookId) {
        userService.addBookToUser(token, bookId);
    }

    @GetMapping("user/books")
    List<BookModel> getBooksReaded(@RequestParam(name = "token") String token) {
        return userService.getBooksReadByUser(token);
    }
}
