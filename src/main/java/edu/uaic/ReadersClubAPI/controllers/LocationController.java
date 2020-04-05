package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.models.Location;
import edu.uaic.ReadersClubAPI.repository.LocationRepository;
import edu.uaic.ReadersClubAPI.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @GetMapping("locations/mock")
    public void mockLocations() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(new Location("Palatul Culturii", 27.586961, 47.157484));
        locationList.add(new Location("Opera Nationala", 27.5846, 47.1648));
        locationList.add(new Location("Facultatea de Informatica Iasi", 27.5749, 47.1743));
        locationRepository.saveAll(locationList);
    }

    @PostMapping("locations/add")
    public Location addLocation(@RequestBody Location location) {
        return this.locationService.addLocation(location);
    }

    @GetMapping("locations")
    public List<Location> getInterestPoints(@RequestParam("longitude") Double longitude,
                                            @RequestParam("latitude") Double latitude) {
        List<Location> locationList = locationRepository.findAll();
        List<Location> resultList = new ArrayList<>();
        for (Location location : locationList) {
            if (locationService.calculateDistance(location.getLongitude(), longitude, location.getLatitude(), latitude) <= 3) {
                resultList.add(location);
            }
        }
        return resultList;
    }

    @GetMapping("locations/all")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
