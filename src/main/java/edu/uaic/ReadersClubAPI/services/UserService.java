package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.User;
import edu.uaic.ReadersClubAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User userToSave) {
        return userRepository.save(userToSave);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
