package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.Coordinates;
import edu.uaic.ReadersClubAPI.models.Location;
import edu.uaic.ReadersClubAPI.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location getLocationById(Long locationId) {
        return locationRepository.findById(locationId).orElseThrow();
    }

    HashMap<String, Coordinates> locationMapping;

    public final void addMapping(String authToken, Double latitude, Double longitude) {
        var coordPair = new Coordinates(latitude, longitude);

        this.locationMapping.put(authToken, coordPair);
    }

    static final Integer R = 6371;

    /*
            Kilometers
     */
    public Double calculateDistance(Double longitude1, Double longitude2, Double latitude1, Double latitude2) {
        Double latDistance = toRad(latitude2 - latitude1);
        Double longDistance = toRad(longitude2 - longitude1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(toRad(latitude1)) * Math.cos(toRad(latitude2)) *
                Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance;
    }

    private Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
