package app.service;

import app.domain.entities.Car;
import app.domain.models.service.CarServiceModel;
import app.domain.repository.CarStorage;
import org.modelmapper.ModelMapper;


import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    ModelMapper modelMapper = new ModelMapper();

//    private final ModelMapper modelMapper;
//
//    public CarServiceImpl() {
//    }


    @Override
    public void addCar(CarServiceModel model) {

        CarStorage.addCar(this.modelMapper.map(model, Car.class));
    }

    @Override
    public List<CarServiceModel> allCars() {
       return CarStorage.getCars().stream()
               .map(car -> modelMapper.map(car, CarServiceModel.class))
               .collect(Collectors.toList());
    }
}
