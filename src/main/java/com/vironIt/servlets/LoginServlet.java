package com.vironIt.servlets;

import com.vironIt.db.dao.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("name","User");
        req.getRequestDispatcher("startpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        UserDAOImpl userDAO = new UserDAOImpl();
        String userName = req.getParameter("login");
        String userPassword = req.getParameter("password");
        User user = userService.findUser(   userName, userPassword);
        if (user != null){
            req.setAttribute("user", user);
            req.setAttribute("name", user.getLogin());
            resp.sendRedirect("user.jsp");
        }else{

        }
    }
}