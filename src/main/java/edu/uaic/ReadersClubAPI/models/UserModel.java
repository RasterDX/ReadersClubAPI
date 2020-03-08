package edu.uaic.ReadersClubAPI.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class UserModel {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    UserModel() {}
}
