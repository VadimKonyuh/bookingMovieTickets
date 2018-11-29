package com.vironIt.servlets;

import com.vironIt.db.dao.impl.CinemaDAOImplHibernate;
import com.vironIt.entity.Cinema;
import com.vironIt.entity.User;
import com.vironIt.service.CinemaService;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
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
        User user = (User) session.getAttribute("user");
        String error = (String) session.getAttribute("error");
        if (user != null && user.getLogin() != null){
            name = user.getLogin();
            CinemaDAOImplHibernate cinemaDAOImplHibernate = new CinemaDAOImplHibernate();
            List<Cinema> cinemaList;
            cinemaList =  cinemaDAOImplHibernate.findAll();
            req.setAttribute("CinemaList",cinemaList);
            req.setAttribute("name", name);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        }else{
            req.setAttribute("error", "session is ended");
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }
}
