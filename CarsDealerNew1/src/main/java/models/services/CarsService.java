package models.services;

import models.entity.User;
import models.service.CarServiceModel;

import java.util.List;

public interface CarsService {
    List<CarServiceModel> getAll();
    void createCar(String model, String brand, String engine, String years, String username);
   // User getUser(String name);
}
