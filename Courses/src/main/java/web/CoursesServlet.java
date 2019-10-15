package web;

import models.serviceModels.CourseServiceModel;
import services.CoursesService;
import services.HtmlService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/courses")
public class CoursesServlet extends ViewHttpServlet {

    final CoursesService coursesService;
    final HtmlService htmlService;

    @Inject
    public CoursesServlet(CoursesService coursesService, HtmlService htmlService) {
        this.coursesService = coursesService;
        this.htmlService = htmlService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<CourseServiceModel> courses = coursesService.getAllCourses();

//        String body =
//               this.htmlService.createCourseForm() +
//                        this.coursesToHtml(courses);
//        this.setHtmlContentType(resp);
        req.setAttribute("courses", courses);

        req.getRequestDispatcher("courses.jsp").forward(req, resp);
       //resp.getWriter().println(body);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("name");
        String coursePrice = req.getParameter("price");
        if (courseName!=""&&coursePrice!=""){
            coursesService.createCourse(courseName, coursePrice );
        }
        resp.sendRedirect("/courses");
    }

    private String coursesToHtml(List<CourseServiceModel> courses) {

        return this.htmlService.getCoursesList(courses);
    }


}
