package servlets;

import models.serviceModels.CourseServiceModel;
import services.CoursesService;
import services.CoursesServiceImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@WebServlet("/")
public class CoursesServlet extends ViewHttpServlet {

    private final Function<CourseServiceModel, String> courseItemFunc =
            course -> String.format("<li>%s</li>", course.getName());

//   final CoursesService coursesService;
//
//   @Inject
//    public CoursesServlet(CoursesService coursesService) {
//        this.coursesService = coursesService;
//    }

    CoursesService coursesService = new CoursesServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseServiceModel> courses = coursesService.getAllCourses();
        String body = this.coursesToHtml(courses);
        this.setHtmlContentType(resp);
        resp.getWriter().println(body);
    }

    private String coursesToHtml(List<CourseServiceModel> courses) {

        return this.getList(courses, courseItemFunc);
    }

    private <T> String getList(List<T> collection, Function<T, String> itemFunc) {
        StringBuilder builder = new StringBuilder();
        collection.forEach(item -> {
            String html = itemFunc.apply(item);
            builder.append(html);
        });
        return String.format("<ul>%s</ul>", builder.toString());
    }
}
