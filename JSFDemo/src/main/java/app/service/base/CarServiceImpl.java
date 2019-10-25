package app.service.base;

import app.domain.entities.Car;
import app.domain.serviceModels.CarServiceModel;
import app.repository.CarRepository;
import app.service.CarService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Inject
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveCar(CarServiceModel carServiceModel) {
        this.carRepository.save(this.modelMapper.map(carServiceModel, Car.class));
    }

    @Override
    public List<CarServiceModel> allCars() {
       List<CarServiceModel> cars = this.carRepository.getCars()
                .stream()
                .map(c-> this.modelMapper.map(c, CarServiceModel.class))
                .collect(Collectors.toList());
       if (!cars.isEmpty()){
           return cars;
       }
        return null;
    }
}
