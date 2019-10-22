package web;


import models.entity.User;
import models.services.CarsService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cars/create")
public class CarsCreateServlet extends HttpServlet {


    private final CarsService carsService;
    private final EntityManager entityManager;

    @Inject
    public CarsCreateServlet(CarsService carsService, EntityManager entityManager) {
        this.carsService = carsService;
        this.entityManager = entityManager;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        req.getRequestDispatcher("/cars-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = (String) req.getSession().getAttribute("username");


        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String engine = req.getParameter("engine");
        String year = req.getParameter("year");

        carsService.createCar(model, brand, engine, year, username);
        resp.sendRedirect("/cars/all");

    }
}
