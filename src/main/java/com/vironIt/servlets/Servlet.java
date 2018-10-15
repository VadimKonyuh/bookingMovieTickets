package com.vironIt.servlets;

import com.vironIt.entity.User;
import com.vironIt.jdbc.HikariCPDataSource;
import com.vironIt.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Servlet extends HttpServlet {



    UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userService.getUsers();
        req.setAttribute("users", users);
        req.setAttribute("name", "Vadim");

        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
    }
}
