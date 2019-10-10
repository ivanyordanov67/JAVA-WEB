package services;

import models.serviceModels.CourseServiceModel;

import java.util.ArrayList;
import java.util.List;

public class CoursesServiceImpl implements CoursesService {

    static List<CourseServiceModel> courses;

    static {
        courses=new ArrayList<>();
        CourseServiceModel model = new CourseServiceModel();
        model.setName("Java Web");
        model.setPrice(180);
        model.setDiscount(0.3);
        courses.add(model);

    }
    @Override
    public List<CourseServiceModel> getAllCourses() {
        return courses;
    }
}
