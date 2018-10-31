package com.vironIt.servlets;

import com.vironIt.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
////        User user = (User) req.getAttribute("user");
//        String name = "name ";
//
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null){
//            for(Cookie cookie : cookies){
//                if(cookie.getName().equals("login"))
//                    name = cookie.getValue();
//            }
//
//        }
////        name += req.getParameter("name");
//        req.setAttribute("name", name);
////        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
//        resp.sendRedirect("/home");
        String name = "name ";

        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("login"))
                    name = cookie.getValue();
            }

        }
//        name += req.getParameter("name");
        req.setAttribute("name", name);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
