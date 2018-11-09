package com.vironIt.servlets;

import com.vironIt.db.dao.impl.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String eMail = req.getParameter("eMail");
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(eMail);
        user.setRole("user");
        UserService userService = new UserService();
        if (password.equals(password1) && login.length() > 5){
            System.out.println(login.length());
            userService.addUser(user);
            req.setAttribute("user", user);
            req.setAttribute("name", login);
            resp.sendRedirect("user.jsp");
//                req.getRequestDispatcher("admin.jsp").forward(req, resp);
        }else {
            req.setAttribute("error", "invalid date");
            req.setAttribute("login", login);
            req.setAttribute("password", password);
            req.setAttribute("password1", password1);
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }
}
