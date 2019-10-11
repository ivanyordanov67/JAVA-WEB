package servlets;

import models.serviceModels.CourseServiceModel;
import services.CoursesService;
import services.CoursesServiceImpl;
import services.HtmlService;
import services.HtmlServiceImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class CoursesServlet extends ViewHttpServlet {




   final CoursesService coursesService;
   final HtmlService htmlService;

   @Inject
    public CoursesServlet(CoursesService coursesService, HtmlService htmlService) {
        this.coursesService = coursesService;
       this.htmlService = htmlService;
   }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseServiceModel> courses = coursesService.getAllCourses();
        String body =
                this.htmlService.createCourseForm()+
                this.coursesToHtml(courses);
        this.setHtmlContentType(resp);
        resp.getWriter().println(body);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String courseName = req.getParameter("name");
        coursesService.createCourse(courseName);
        resp.sendRedirect("/courses");
    }

    private String coursesToHtml(List<CourseServiceModel> courses) {

        return this.htmlService.getCoursesList(courses);
    }


}
