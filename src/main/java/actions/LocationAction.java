package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Location;
import lombok.Getter;
import lombok.Setter;
import service.LocationService;

import java.util.List;
import java.util.UUID;

public class LocationAction extends ActionSupport {

    @Inject
    private LocationService locationService;

    @Getter
    @Setter
    private Location location;

    @Getter
    private List<Location> locations;

    @Getter
    private UUID id;

    public String createLocation() {
        locationService.createLocation(location);
        return SUCCESS;
    }

    public String getLocation() {
        location = locationService.getLocation(id);
        if (location == null) {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getAllLocations() {
        locations = locationService.getAllLocations();
        return SUCCESS;
    }

    public String updateLocation() {
        location = locationService.updateLocation(location);
        return SUCCESS;
    }

    public String deleteLocation() {
        locationService.deleteLocation(id);
        return SUCCESS;
    }
}
