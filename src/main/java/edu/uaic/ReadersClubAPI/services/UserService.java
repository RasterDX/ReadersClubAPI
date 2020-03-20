package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import edu.uaic.ReadersClubAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    @Autowired
    BookRepository bookRepository;

    public UserModel saveUser(UserModel userToSave) {
        return userRepository.save(userToSave);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserModel getUserByEmail(String email) { return userRepository.findUserByEmail(email); }

    public void addBookToUser(String token, Long bookId) {
        UserModel user = authService.getUserWithToken(token);
        BookModel book = bookRepository.getOne(bookId);
        user.getBooks().add(book);
        userRepository.save(user);
    }

    public List<BookModel> getBooksReadByUser(String token) {
        UserModel user = authService.getUserWithToken(token);
        return new ArrayList<>(user.getBooks());
    }
}
