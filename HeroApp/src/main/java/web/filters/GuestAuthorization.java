package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/home.jsf", "/views/add-hero.jsf"})
public class GuestAuthorization implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String id = (String) ((HttpServletRequest)servletRequest)
                .getSession().getAttribute("username");

        if (id==null){
            ((HttpServletResponse)servletResponse).sendRedirect("/views/index.jsf");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
