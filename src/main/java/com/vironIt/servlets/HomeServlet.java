package com.vironIt.servlets;

import com.vironIt.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        System.out.println(user);
        String name = "name ";
        name += req.getParameter("name");
        req.setAttribute("name", name);
//        req.getRequestDispatcher("user.jsp").forward(req, resp);
        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
