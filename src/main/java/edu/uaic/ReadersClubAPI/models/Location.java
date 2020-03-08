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
    private Double xCoord;
    private Double yCoord;
    private String description;
    private String userInterest;
}
