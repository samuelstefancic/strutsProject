package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Car;
import lombok.Getter;
import lombok.Setter;
import service.CarService;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CarAction extends ActionSupport {

    @Inject
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
}
