package web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class UsersRegisterServlet extends HttpServlet {

//    private final UsersService usersService;
//
//
//    @Inject
//    public UsersRegisterServlet(UsersService usersService) {
//        this.usersService = usersService;
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/users-register.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String username = req.getParameter("username");
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String confirmPassword = req.getParameter("confirmPassword");
//
//        usersService.register(username, email, password, confirmPassword);
//
//
//
//
//
//
//    }
}
