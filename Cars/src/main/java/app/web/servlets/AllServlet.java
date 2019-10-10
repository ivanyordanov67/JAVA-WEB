package app.web.servlets;

import app.domain.models.view.CarViewModel;
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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/all")
public class AllServlet extends HttpServlet {

    CarService carService = new CarServiceImpl();

    private final static String FILE_PATH =
            "C:\\Users\\ivan\\Documents\\GitHub\\JAVA-WEB\\Cars\\src\\main\\webapp\\views\\all.html";

//    private final FileUtil fileUtil;
//
//    @Inject
//    public AllServlet(FileUtil fileUtil) {
//        this.fileUtil = fileUtil;
//    }

    FileUtilTest fileUtil = new FileUtilTestImpl();
    ModelMapper modelMapper = new ModelMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String html = fileUtil.readFile(FILE_PATH);

        StringBuilder sb = new StringBuilder();
        List<CarViewModel> cars = carService.allCars()
                .stream().map(c-> this.modelMapper.map(c, CarViewModel.class))
                .collect(Collectors.toList());

        for (CarViewModel car : cars) {
            sb.append(String.format("<li class = \"d-flex justify-content-around\">\n" +
                    " <div class = \" col-md-4 d-flex flex-column text-center mb-3\">\n " +
                    " <h2 class = \" text-white text-center\">Brand: %s<h2>\n" +
                    " <h4 class = \" text-white text-center\">Model: %s<h4>\n" +
                    " <h4 class = \" text-white text-center\">Year: %s<h4>\n" +
                    " <h4 class = \" text-white text-center\">Engine: %s<h4>\n" +
                    " </div>\n"+
                    "</li>", car.getBrand(), car.getModel(), car.getYear(), car.getEngine()));
        }

        html = html.replace("{{replace}}", sb.toString());
        out.println(html);


    }
}
