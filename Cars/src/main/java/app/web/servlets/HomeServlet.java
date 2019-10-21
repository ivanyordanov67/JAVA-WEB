package app.web.servlets;

import app.util.FileUtilTest;
import app.util.FileUtilTestImpl;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;

@WebServlet("/")
public class HomeServlet extends HttpServlet {


    //     private  FileUtilTest fileUtil;
//
//    @Inject
//    public HomeServlet(FileUtilTestImpl fileUtil) {
//        this.fileUtil = fileUtil;
//    }
//
    FileUtilTest fileUtil = new FileUtilTestImpl();

    private final static String FILE_PATH =
            "C:\\Users\\ivan\\Documents\\GitHub\\JAVA-WEB\\Cars\\src\\main\\webapp\\views\\home.html";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();


        String html = fileUtil.readFile(FILE_PATH);


        out.println(html);

    }
}
