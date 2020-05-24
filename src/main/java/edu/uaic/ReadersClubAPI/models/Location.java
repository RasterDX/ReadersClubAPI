package edu.uaic.ReadersClubAPI.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.uaic.ReadersClubAPI.dtos.UserDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="location_mapper")
public class Location {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String name;
    private Double longitude;
    private Double latitude;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private String userInterest;
    @Column(nullable = true)
    private String imageUrl;
    @ManyToOne
    @JsonIgnoreProperties("locations")
    private BookModel book;
    @OneToMany
    private List<UserModel> usersWhoVisited;

    public List<UserModel> getUsersWhoVisited() {
        return usersWhoVisited;
    }

    public void setUsersWhoVisited(List<UserModel> usersWhoVisited) {
        this.usersWhoVisited = usersWhoVisited;
    }

    public Location(BookModel book, String name, Double latitude, Double longitude) {
        this.book = book;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(String name, Double longitude, Double latitude, String imageUrl) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imageUrl = imageUrl;
    }

    Location()  {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }
}
