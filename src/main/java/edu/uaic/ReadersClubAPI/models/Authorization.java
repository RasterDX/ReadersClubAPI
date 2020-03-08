package edu.uaic.ReadersClubAPI.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorizations")
public class Authorization {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String authToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserModel user;

    public Authorization(String authToken, UserModel user) {
        this.authToken = authToken;
        this.user = user;
    }

    Authorization() {}
}
