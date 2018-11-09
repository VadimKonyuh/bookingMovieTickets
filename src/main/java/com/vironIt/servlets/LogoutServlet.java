package com.vironIt.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    System.out.println("user=" + cookie.getValue());
                    break;
                }
            }
        }

        HttpSession session = req.getSession(false);
        if (session != null){
            session.invalidate();
        }
        resp.sendRedirect("/login");
//        log("\"After logout = \" + session");
    }
}
