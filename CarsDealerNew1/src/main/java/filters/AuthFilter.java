package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns =
        "/users/login," +
        "/users/register," +
                "/cars/all," +
                "/cars/create")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String username = request
                .getSession()
                .getAttribute("username").toString();

        if(username==null){
            response.sendRedirect("/users/login");
        }
        filterChain.doFilter(request,response);

    }
}