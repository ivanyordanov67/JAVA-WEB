package services;

import models.serviceModels.CourseServiceModel;

import java.util.List;

public interface HtmlService {

    String getCoursesList(List<CourseServiceModel> courses);

    String createCourseForm();

}
