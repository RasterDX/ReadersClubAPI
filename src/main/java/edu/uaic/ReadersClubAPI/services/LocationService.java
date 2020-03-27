package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.Coordinates;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocationService {

    //Spring uses multithreading somewhere. Thread safe is required
     Map<String, Coordinates> locationMapping = new ConcurrentHashMap<>();

    public final void addMapping(String authToken, Double latitude, Double longitude) {
        var coordPair = new Coordinates(latitude, longitude);
        this.locationMapping.put(authToken, coordPair);
        printLocationMapping();
    }

    private void printLocationMapping() {
        locationMapping.forEach((k, v) -> {
            System.out.println(k + " " + v.toString());

        });
        System.out.println("--------------------------");
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
