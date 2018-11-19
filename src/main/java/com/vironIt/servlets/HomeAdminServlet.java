package com.vironIt.servlets;

import com.vironIt.db.dao.impl.CinemaDAOImpl;
import com.vironIt.entity.Cinema;
import com.vironIt.entity.User;
import com.vironIt.service.CinemaService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeAdminServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = "";
        String[] id = req.getParameterValues("cinemaId");
        String select[] = req.getParameterValues("cinemaId");
        if (select != null && select.length != 0) {
            CinemaService cinemaService = new CinemaService();
            for (int i = 0; i < select.length; i++) {
                cinemaService.deleteCinemaById(Integer.parseInt(select[i]));
                log("You are delete " + select[i]);
            }
        }

        HttpSession session = req.getSession();
//        if (session == null){
//            resp.sendRedirect("/login");
//        }

        User user = (User) session.getAttribute("user");
        String error = (String) session.getAttribute("error");


        if (user != null && user.getLogin() != null){
            name = user.getLogin();
            CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
            List<Cinema> cinemaList;
            cinemaList =  cinemaDAO.findAll();
            req.setAttribute("CinemaList",cinemaList);
            req.setAttribute("name", name);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        }else{
            req.setAttribute("error", "session is ended");
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}
