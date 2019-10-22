package models.services.base;

import models.entity.Car;
import models.entity.Engine;
import models.service.CarServiceModel;
import models.services.CarsService;
import models.services.UserService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarsServiceImpl implements CarsService {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Inject
    public CarsServiceImpl(EntityManager entityManager, ModelMapper modelMapper, UserService userService) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public List<CarServiceModel> getAll() {
    return entityManager.createQuery("select c from Car c", Car.class)
              .getResultList()
            .stream()
            .map(car -> modelMapper.map(car, CarServiceModel.class))
            .collect(Collectors.toList());

    }

    @Override
    public void createCar(String model, String brand, String engine, String years,String username) {

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(years);
        car.setEngine(Engine.valueOf(engine));
        car.setUser(userService.getUserByName(username));

        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();


    }



}
