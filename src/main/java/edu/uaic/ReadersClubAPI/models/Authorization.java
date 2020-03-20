package edu.uaic.ReadersClubAPI.models;


import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
