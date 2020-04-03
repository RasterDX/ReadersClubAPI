package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.dtos.UserDTO;
import edu.uaic.ReadersClubAPI.models.*;
import edu.uaic.ReadersClubAPI.services.InvitationService;
import edu.uaic.ReadersClubAPI.services.LocationService;
import edu.uaic.ReadersClubAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @Autowired
    InvitationService invitationService;

    @PostMapping("user")
    UserModel postUser(@RequestBody UserModel userToAdd) {
        return userService.saveUser(userToAdd);
    }

    @GetMapping("user/{token}")
    UserDTO getUser(@PathVariable String token) {
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
    void updateUserLocation(@RequestParam(name = "authToken") String authtoken, @RequestParam(name = "latitude") Double latitude, @RequestParam(name = "longitude") Double longitude) {
        locationService.addMapping(authtoken, latitude, longitude);
    }

    @GetMapping("user/getmatches")
    List<UserAndBooksPair> getMatchesForUser(@PathVariable(name = "authToken") String token) {
        return this.userService.getMatchesForUser(token);
    }

    @PostMapping(value = "user/invite")
    String inviteMatch(@RequestBody(required = true) InviteRequest inviteRequest) {
        try {
            var sender = userService.getUserById(inviteRequest.senderId);
            var receiver = userService.getUserById(inviteRequest.receiverId);
            if (userService.getUser(inviteRequest.authToken).getEmail().equals(sender.getEmail())) {
                if (userService.getMatchesForUser(inviteRequest.authToken).stream()
                        .anyMatch(m -> m.getUser().getEmail().equals(receiver.getEmail()))) {
                    invitationService.createInvitation(inviteRequest.senderId, inviteRequest.receiverId, inviteRequest.locationId, inviteRequest.bookId, inviteRequest.date, inviteRequest.message);
                } else {
                    return "Cannot send invitation to user who is not a match.";
                }
            } else {
                return "Illegal request.";
            }

        } catch (Exception e) {
            return "Illegal request";
        }
        return "Could not complete request.";
    }

    @GetMapping("user/get-invitations/{email}")
    List<Invitation> getInvitationForEmail(@PathVariable(value = "") String email) {
        return invitationService.getInvitationsByEmail(email);
    }
}
