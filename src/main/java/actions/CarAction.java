package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Car;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CarService;

import java.util.List;
import java.util.UUID;
@Controller
@Action
@Getter
@Setter
public class CarAction extends ActionSupport {

    @Autowired
    private CarService carService;


    private Car car;

    private List<Car> cars;


    private UUID id;

    public String createCar() {
        carService.createCar(car);
        if (car == null) {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getCar() {
        car = carService.getCar(id);
        if (car == null) {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getAllCars() {
        cars = carService.getAllCars();
        return SUCCESS;
    }

    public String updateCar() {
        car = carService.updateCar(car);
        return SUCCESS;
    }

    public String deleteCar() {
        carService.deleteCar(id);
        return SUCCESS;
    }

    public CarService getCarService() {
        return carService;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public UUID getId() {
        return id;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public void setId(UUID id) {
        this.id = id;
    }
}
