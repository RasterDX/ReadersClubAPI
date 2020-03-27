package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.dtos.UserDTO;
import edu.uaic.ReadersClubAPI.models.Authorization;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Random;


@Service
public class AuthService {

    @Autowired
    UserService userService;

    @Autowired
    AuthorizationRepository authorizationRepository;

    public String generateAuthToken() {
        var SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        var salt = new StringBuilder();
        var rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public String login(String email, String password) {
        var user = userService.getUserByEmail(email);
        if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
            var authUser = authorizationRepository.getAuthForEmail(email);
            if (authUser.isPresent()) {
                return authUser.get().getAuthToken();
            } else {
                var authorization = authorizationRepository.save(new Authorization(generateAuthToken(), user));
                return authorization.getAuthToken();
            }
        }
        else {
            return "invalid credentials";
        }
    }

    public UserDTO getUserDTOForToken(String token) {
        var modelMapper = new ModelMapper();
        Authorization auth = authorizationRepository.getAuthorizationByToken(token).get();
        return modelMapper.map(auth.getUser(), UserDTO.class);
    }

    public UserModel getUserModelForToken(String token) {
        var modelMapper = new ModelMapper();
        Authorization auth = authorizationRepository.getAuthorizationByToken(token).get();
        return auth.getUser();
    }
}
