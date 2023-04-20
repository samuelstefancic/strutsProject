package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.Car;
import entity.Modele;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CarService;
import service.ModeleService;

import java.util.List;
import java.util.UUID;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller
@Action
@Getter
@Setter
@Actions({
        @Action(value="showCreateCarForm", results = {
                @Result(name = SUCCESS, location = "/WEB-INF/jsp/createCar.jsp")
        }),
        @Action(value = "createCar", results = {
                @Result(name = SUCCESS, type = "redirect", location = "carSuccess"),
                @Result(name = ERROR, location = "/WEB-INF/jsp/createCar.jsp")
        })
})
public class CarAction extends ActionSupport {

    @Autowired
    private CarService carService;
    @Autowired
    private ModeleService modeleService;

    private Car car;

    private List<Car> cars;
    private List<Modele> modeles;
    private UUID id;

    public CarAction() {
        car = new Car();
    }

    public List<Modele> getModeles() {
        return modeles;
    }

    public String createCar() {
        if (car == null || car.getCouleur() == null || car.getPoids() == null || car.getTypeCarburant() == null || car.getModele() == null || car.getModele().getId() == null) {
            addActionError("Tous les champs sont obligatoires.");
            return ERROR;
        }
        carService.createCar(car);
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

    public String showCreateCarForm() {
        modeles = modeleService.getAllModeles();
        return SUCCESS;
    }
    public String showCarSuccess() {
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
