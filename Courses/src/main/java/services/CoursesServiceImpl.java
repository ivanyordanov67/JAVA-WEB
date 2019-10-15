package services;

import models.entities.Course;
import models.serviceModels.CourseServiceModel;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoursesServiceImpl implements CoursesService {

    EntityManager entityManager =
            Persistence.createEntityManagerFactory("courses_db")
                    .createEntityManager();


    @Override
    public List<CourseServiceModel> getAllCourses() {

        return entityManager.createQuery("SELECT c FROM courses c", Course.class)
                .getResultList()
                .stream()
                .map(course -> {
                    CourseServiceModel model = new CourseServiceModel();
                    model.setName(course.getName());
                    model.setId(course.getId());
                    model.setPrice(course.getPrice());

                    return model;
                }).collect(Collectors.toList());

    }

    @Override
    public void createCourse(String name, String price) {
      entityManager.getTransaction().begin();
       Course course = new Course();
       course.setName(name);
       course.setPrice(price);
       entityManager.persist(course);
       entityManager.getTransaction().commit();

    }
}
