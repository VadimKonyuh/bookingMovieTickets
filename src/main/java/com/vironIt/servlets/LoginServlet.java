package com.vironIt.servlets;

import com.vironIt.db.dao.impl.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.service.UserService;
import javax.servlet.http.Cookie;
import org.mortbay.jetty.servlet.AbstractSessionManager;

import javax.servlet.ServletException;
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

        UserService userService = new UserService();
        User user= null;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        user = userService.getUserByLoginPassword(login, password);
        if (login.equals(user.getLogin()) && password.equals(user.getPassword())){
            Cookie logincookie = new Cookie("login", login);
            logincookie.setMaxAge(30*60);
            resp.addCookie(logincookie);
//            resp.sendRedirect("/home");

//            req.setAttribute("name", user.getFirstName());
//            req.setAttribute("login", user.getLogin());
//            req.setAttribute("password", user.getPassword());
//            req.setAttribute("user", user);
            req.getRequestDispatcher("/home").forward(req, resp);
        }else{
            resp.sendRedirect("/login");
        }
    }
}