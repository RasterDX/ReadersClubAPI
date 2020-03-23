package edu.uaic.ReadersClubAPI.models;

import edu.uaic.ReadersClubAPI.dtos.UserDTO;

import java.util.Set;

public class UserAndBooksPair {

    private UserDTO user;
    private Set<BookModel> books;

    public UserAndBooksPair(UserDTO user, Set<BookModel> books) {
        this.user = user;
        this.books = books;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }
}
