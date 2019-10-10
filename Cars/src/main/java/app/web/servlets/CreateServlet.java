package app.web.servlets;

import app.domain.models.binding.CarCreateBindingModel;
import app.domain.models.service.CarServiceModel;
import app.service.CarService;
import app.service.CarServiceImpl;
import app.util.FileUtilTest;
import app.util.FileUtilTestImpl;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    FileUtilTest fileUtil = new FileUtilTestImpl();
 CarService carService = new CarServiceImpl();
   ModelMapper modelMapper = new ModelMapper();

    private final static String FILE_PATH =
            "C:\\Users\\ivan\\Documents\\GitHub\\JAVA-WEB\\Cars\\src\\main\\webapp\\views\\create.html";

//    public CreateServlet(CarService carService, ModelMapper modelMapper) {
//        this.carService = carService;
//        this.modelMapper = modelMapper;
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();


        String html = fileUtil.readFile(FILE_PATH);


        out.println(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarCreateBindingModel bindingModel = new CarCreateBindingModel();
        bindingModel.setBrand(req.getParameter("brand"));
        bindingModel.setModel(req.getParameter("model"));
        bindingModel.setYear(Integer.parseInt(req.getParameter("year")));
        bindingModel.setEngine(req.getParameter("engine"));

        this.carService.addCar(modelMapper.map(bindingModel, CarServiceModel.class));


        resp.sendRedirect("/all");
    }
}
