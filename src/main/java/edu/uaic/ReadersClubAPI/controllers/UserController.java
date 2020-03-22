package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.services.LocationService;
import edu.uaic.ReadersClubAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @PostMapping("user")
    UserModel postUser(@RequestBody UserModel userToAdd) {
        return userService.saveUser(userToAdd);
    }

    @GetMapping("user/{token}")
    UserModel getUser(@PathVariable String token) {
        return userService.getUser(token);
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

    @PostMapping("user/location")
    void updateUserLocation(@RequestParam(name="authToken") String authtoken, @RequestParam(name = "xCoord") Double xCoord, @RequestParam(name="yCoord") Double yCoord) {
        locationService.addMapping(authtoken, xCoord, yCoord);
    }
}
