package edu.uaic.ReadersClubAPI.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
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

    public Location(String name, Double longitude, Double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    Location()  {}
}
