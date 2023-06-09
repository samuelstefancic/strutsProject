package dao;

import entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

public class LocationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void createLocation(Location location) {
         entityManager.persist(location);
    }

    public Location getLocation(UUID id) {
        return entityManager.find(Location.class,id);
    }

    public List<Location> getAllLocations() {
        return entityManager.createQuery("SELECT l FROM Location l", Location.class).getResultList();
    }

    //Update

    public Location updateLocation (Location location) {
        return entityManager.merge(location);
    }

    //Delete

    public void deleteLocation(UUID id) {
        Location location = entityManager.find(Location.class, id);
        if (location != null) {
            entityManager.remove(location);
        }
    }
}
