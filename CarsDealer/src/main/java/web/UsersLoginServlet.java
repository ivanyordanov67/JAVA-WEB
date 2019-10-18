package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/users/login")
public class UsersLoginServlet extends HttpServlet {

//    private final UsersService usersService;
//
//    @Inject
//    public UsersLoginServlet(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        req.getRequestDispatcher("/users-login.jsp").forward(req, resp);
//    }

    //@Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//       // UserServiceModel user = usersService.login(username, password);
//        resp.sendRedirect("/home");
//
//
//    }
}
