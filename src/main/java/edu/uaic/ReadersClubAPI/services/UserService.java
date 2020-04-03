package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.dtos.UserDTO;
import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.UserAndBooksPair;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import edu.uaic.ReadersClubAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    @Autowired
    LocationService locationService;

    @Autowired
    BookRepository bookRepository;

    public UserModel saveUser(UserModel userToSave) {
        return userRepository.save(userToSave);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDTO getUser(String token) {
        return authService.getUserDTOForToken(token);
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void addBookToUser(String token, Long bookId) {
        UserModel user = authService.getUserModelForToken(token);
        BookModel book = bookRepository.getOne(bookId);
        user.getBooks().add(book);
        userRepository.save(user);
    }

    public List<BookModel> getBooksReadByUser(String token) {
        UserModel user = authService.getUserModelForToken(token);
        return new ArrayList<>(user.getBooks());
    }

    public List<UserAndBooksPair> getMatchesForUser(String token) {
        var locationMapping = this.locationService.locationMapping;
        List<UserAndBooksPair> matchingUsers = new ArrayList<>();
        locationMapping.forEach((k, v) -> {
            if (!k.equals(token) && locationMapping.containsKey(k)) {
                var dist = locationService.calculateDistance(locationMapping.get(token).getLongitude(),
                        locationMapping.get(k).getLongitude(), locationMapping.get(token).getLatitude(),
                        locationMapping.get(k).getLatitude());
                var coord = locationMapping.get(k);
                var user = this.getUser(token);
                var matchingUser = this.getUser(k);
                var modelMapper = new ModelMapper();
                if (dist <= 1 && !Collections.disjoint(user.getBooks(), matchingUser.getBooks())) {
                    matchingUsers.add(new UserAndBooksPair(modelMapper.map(matchingUser, UserDTO.class),
                            matchingUser.getBooks(), coord));
                }            }

        });
        return matchingUsers;
    }
}
