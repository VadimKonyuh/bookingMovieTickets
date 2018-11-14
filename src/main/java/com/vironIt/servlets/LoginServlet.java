package com.vironIt.servlets;


import com.vironIt.db.dao.impl.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;


import javax.servlet.ServletException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = null;
        User user = null;
        String page = "";
        UserService userService = new UserService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        user = userService.getUserByLoginPassword(login, password);

        if (login.equals(user.getLogin()) && password.equals(user.getPassword())){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            session.setAttribute("error","");
            session.setMaxInactiveInterval(60);
            Cookie loginCookie = new Cookie("login", login);
            loginCookie.setMaxAge(30*60);
            resp.addCookie(loginCookie);
            req.setAttribute("name", login);
            if (user.getRole().toString().toLowerCase().equals("admin")){
                page = "/home";
            }else {
                page = "user.jsp";
            }
            resp.sendRedirect(page);
        }else{
                error = "You entered an incorrect username or password";
                req.setAttribute("error", error);
                page = "login.jsp";
                req.getRequestDispatcher(page).forward(req, resp);
        }
    }
}