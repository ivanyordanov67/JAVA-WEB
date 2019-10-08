package app.service;

import app.domain.entities.Car;
import app.domain.models.service.CarServiceModel;

import java.util.List;

public interface CarService {

    void addCar(CarServiceModel model);

    List<CarServiceModel> allCars();
}
