package dao;

import entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

public class CarDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void createCar(Car car) {
        entityManager.persist(car);
    }

    public Car getCar(UUID id) {
        return entityManager.find(Car.class, id);
    }

    public List<Car> getAllCars() {
        return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }

    public Car updateCar(Car car) {
        return entityManager.merge(car);
    }

    public void deleteCar(UUID id) {
        Car car = entityManager.find(Car.class, id);
        if (car != null) {
            entityManager.remove(car);
        }
    }
}
