package edu.uaic.ReadersClubAPI.models;

import edu.uaic.ReadersClubAPI.dtos.UserDTO;

import java.util.Set;

public class UserAndBooksPair {

    private UserDTO user;
    private Set<BookModel> books;
    private Coordinates coordinates;

    public UserAndBooksPair(UserDTO user, Set<BookModel> books, Coordinates coordinates) {
        this.user = user;
        this.books = books;
        this.coordinates = coordinates;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
