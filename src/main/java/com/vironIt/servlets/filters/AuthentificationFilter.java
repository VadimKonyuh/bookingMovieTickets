package com.vironIt.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@WebFilter()
public class AuthentificationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            this.context = filterConfig.getServletContext();
            this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
        System.out.println("In intercepter");

        HttpSession session = req.getSession(false);
        if(session == null ){
            req.setAttribute("error", "session is ended from intercepter");
            req.getRequestDispatcher("/login").forward(req, res);
        }else {
            log.println("doFilter");
            filterChain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
