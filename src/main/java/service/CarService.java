package service;

import com.opensymphony.xwork2.inject.Inject;
import dao.CarDAO;
import entity.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CarService {

    @Inject
    private CarDAO carDAO;

    public void createCar(Car car) {
        if (car == null || car.getId() == null) {
            throw new IllegalArgumentException("Invalid car object for creation");
        }
        carDAO.createCar(car);
    }

    public Car getCar(UUID id) {
        return carDAO.getCar(id);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public Car updateCar(Car car) {
        if (car == null || car.getId() == null) {
            throw new IllegalArgumentException("Invalid car object for update");
        }
        Car existCar = carDAO.getCar(car.getId());
        if (existCar == null) {
            throw new IllegalArgumentException("Car not found for update");
        }
        return carDAO.updateCar(car);
    }

    public void deleteCar(UUID id) {
        carDAO.deleteCar(id);
    }

}
