package services;

import models.serviceModels.CourseServiceModel;

import java.util.List;

public interface CoursesService {

    List<CourseServiceModel> getAllCourses();

    void createCourse(String courseName);

}
