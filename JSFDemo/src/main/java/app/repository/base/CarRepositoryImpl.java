package app.repository.base;

import app.domain.entities.Car;
import app.repository.CarRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    public CarRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Car> getCars() {

        entityManager.getTransaction().begin();
        List<Car> cars = entityManager
                .createQuery("select c from Car c", Car.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return cars;
    }
}
