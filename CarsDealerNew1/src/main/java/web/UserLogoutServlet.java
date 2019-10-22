package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.getSession().getAttribute("username").toString();
            req.getSession().setAttribute("username", null);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }catch (Exception e){

            resp.sendRedirect("/users/login");
        }

    }
}
