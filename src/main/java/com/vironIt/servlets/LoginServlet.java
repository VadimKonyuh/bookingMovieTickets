package com.vironIt.servlets;

import com.vironIt.db.dao.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Cookie cookie = new Cookie("myCookie","Value");
        req.setAttribute("name","guest");
        req.getRequestDispatcher("startpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = null;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        user = userDAO.getUserByLoginPassword(login, password);
        System.out.println(user);
        if (login.equals(user.getLogin()) && password.equals(user.getPassword())){
            req.setAttribute("name", user.getFirst_name());
            req.setAttribute("login", user.getLogin());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("user", user);

            System.out.println("1");
            req.getRequestDispatcher("/home").forward(req, resp);
        }else{
            resp.sendRedirect("/login");
            System.out.println("Hello from invalid date");
        }
        System.out.println(login + " " + password);

    }
}