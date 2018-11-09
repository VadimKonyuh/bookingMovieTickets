package com.vironIt.servlets;

import com.vironIt.entity.Cinema;
import com.vironIt.service.CinemaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.sendRedirect("/admin");
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CinemaService cinemaService = new CinemaService();
        Cinema cinema = new Cinema();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        cinema.setName(name);
        cinema.setAddress(address);
        cinemaService.addCinema(cinema);
        HttpSession session = req.getSession(false);
        session.setAttribute("error", "cinema was added");
        resp.sendRedirect("/home");
    }
}
