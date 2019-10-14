package servlets;

import models.entities.Course;
import models.views.HomeViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setName("Ivan");
        homeViewModel.setCreatedOn(new Date());

        req.setAttribute("viewModel", homeViewModel);
        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);
    }
}
