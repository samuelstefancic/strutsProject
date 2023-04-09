package service;

import com.opensymphony.xwork2.inject.Inject;
import dao.LocationDAO;
import entity.Location;

import java.util.List;
import java.util.UUID;

public class LocationService {

    @Inject
    private LocationDAO locationDAO;

    public void createLocation(Location location) {
        if (location == null || location.getId() == null) {
            throw new IllegalArgumentException("The location object is invalid");
        }
        locationDAO.createLocation(location);
    }

    public Location getLocation(UUID id) {
        return locationDAO.getLocation(id);
    }

    public List<Location> getAllLocations() {
        return locationDAO.getAllLocations();
    }

    public Location updateLocation(Location location) {
        if (location == null || location.getId() == null) {
            throw new IllegalArgumentException("Invalid location object for update");
        }
        Location existLocation = locationDAO.getLocation(location.getId());
        if (existLocation == null) {
            throw new IllegalArgumentException("Location not found for update");
        }
        return locationDAO.updateLocation(location);
    }

    public void deleteLocation(UUID id) {
        locationDAO.deleteLocation(id);
    }
}
