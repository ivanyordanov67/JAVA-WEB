package filters;

import services.DateService;

import javax.inject.Inject;
import javax.jms.Message;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

@WebFilter(urlPatterns = {"/courses/*", "/home"})
public class LoggingFilter implements Filter {

    private final DateService dateService;

    @Inject
    public LoggingFilter(DateService dateService) {
        this.dateService = dateService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;



        String time = dateService.getNowFormatted();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String method = request.getMethod();


        String result =
                MessageFormat.format(
                        "[{0}] : {1} -> {2} {3}",
                        time,
                        ip,
                        url,
                        method);
        System.out.println(result);
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
