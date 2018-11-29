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
                    if (name.length() <= 30 && address.length() <= 30) {
                            cinema.setName(name);
                            cinema.setAddress(address);
                            cinemaService.addCinema(cinema);
                            HttpSession session = req.getSession(false);
                            session.setAttribute("error", "Cinema was added");
                    }else{
                        HttpSession session = req.getSession(false);
                        session.setAttribute("error", "Name or address more then 30 symbol");
                    }
                    break;
                case "cinema update":
                    Integer cinemaId = Integer.parseInt(req.getParameter("cinemaId"));
                    cinema = cinemaService.getCinemaById(cinemaId);
                        String newName = req.getParameter("newName");
                        String newAddress = req.getParameter("newAddress");
                        if (newName.length() <= 30){
                            if (!newName.equals(null) && !newAddress.equals(null)){
                                cinema.setName(newName);
                                cinema.setAddress(newAddress);
                                cinemaService.updateCinema(cinema);
                                HttpSession session = req.getSession(false);
                                session.setAttribute("error", "Cinema object was update");
                            }else {
                                HttpSession session = req.getSession(false);
                                session.setAttribute("error", "Cinema name or address are empty");
                            }
                        }else {
                            HttpSession session = req.getSession(false);
                            session.setAttribute("error", "Cinema name or address more then 30 symbol");
                        }
//                    }
                    break;
            }
        }
        resp.sendRedirect("/home");
    }
}
