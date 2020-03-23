package edu.uaic.ReadersClubAPI.dtos;

import edu.uaic.ReadersClubAPI.models.BookModel;

import java.util.Set;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;

    private Set<BookModel> books;

    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }
}
