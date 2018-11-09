package com.vironIt.servlets;

import com.vironIt.db.dao.impl.CinemaDAOImpl;
import com.vironIt.entity.Cinema;
import com.vironIt.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = "";

        HttpSession session = req.getSession();
        if (session == null){
            resp.sendRedirect("/login");
        }else {
//            String error = (String) session.getAttribute("error");
        }

        User user = (User) session.getAttribute("user");
        String error = (String) session.getAttribute("error");


        if (user != null && user.getLogin() != null){
            name = user.getLogin();
//            CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
//            List<Cinema> cinemaList = new ArrayList<>();
//            cinemaList =  cinemaDAO.findAll();
//            req.setAttribute("cinemas",cinemaList);
//            System.out.println(cinemaList);
            req.setAttribute("name", name);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        }else{
            req.setAttribute("error", "session is ended");
            req.getRequestDispatcher("/login").forward(req, resp);
//            resp.sendRedirect("/login");
        }
    }
}
