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

        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String button = req.getParameter("button");
        CinemaService cinemaService = new CinemaService();
        Cinema cinema = new Cinema();


        if (!button.equals(null)){
            switch (button){
                case "add cinema" :
                    String name = req.getParameter("name");
                    String address = req.getParameter("address");
                    if (!(cinemaService.getCinemaByName(name).getName() == null)){
                        cinema.setName(name);
                        cinema.setAddress(address);
                        cinemaService.addCinema(cinema);
                        HttpSession session = req.getSession(false);
                        session.setAttribute("error", "cinema was added");
                    }else {
                        HttpSession session = req.getSession(false);
                        session.setAttribute("error", "You can not add film with name null");
                    }
                    break;
                case "cinema update":
                    String oldName = req.getParameter("oldName");
                    String oldAddress = req.getParameter("oldAddress");
                    cinema = cinemaService.getCinemaByNameAddress(oldName, oldAddress);
                    if (!(cinema.getName() == null)){
                        String newName = req.getParameter("newName");
                        String newAddress = req.getParameter("newAddress");
                        cinema.setName(newName);
                        cinema.setAddress(newAddress);
                        cinemaService.updateCinema(cinema);
                        HttpSession session = req.getSession(false);
                        session.setAttribute("error", "cinema object was update");
                    }
                    break;
            }
        }
        resp.sendRedirect("/home");
    }
}
