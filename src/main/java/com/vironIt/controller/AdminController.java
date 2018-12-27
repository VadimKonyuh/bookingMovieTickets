package com.vironIt.controller;

import com.vironIt.db.dao.impl.CinemaDAOImplHibernate;
import com.vironIt.entity.Cinema;
import com.vironIt.service.CinemaService;
import org.mortbay.log.Log;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPageGet(HttpServletRequest req, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        String user = getPrincipal();
        Log.info(user.toString());
        CinemaDAOImplHibernate cinemaDAOImplHibernate = new CinemaDAOImplHibernate();
        List<Cinema> cinemaList = cinemaDAOImplHibernate.findAll();
        req.setAttribute("CinemaList",cinemaList);
        req.setAttribute(user, user);

        model.addAttribute("user", getPrincipal());
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.PUT)
    public ModelAndView adminPagePost(HttpServletRequest req, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");

        Log.info("-1");
        String button = req.getParameter("button");
        Log.info("0");
        CinemaService cinemaService = new CinemaService();
        Cinema cinema = new Cinema();
        if (!button.equals(null)){
            switch (button){
                case "add cinema" :
                    String name = req.getParameter("name");
                    Log.info("1");
                    String address = req.getParameter("address");
                    Log.info("2");
                    if (name.length() <= 30 && address.length() <= 30) {
                        Log.info("3");
                        cinema.setName(name);
                        Log.info("4");
                        cinema.setAddress(address);
                        Log.info("5");
                        cinemaService.addCinema(cinema);
                        Log.info("6");
                        HttpSession session = req.getSession(false);
                        Log.info("7");
                        session.setAttribute("error", "Cinema was added");
                    }else{
                        HttpSession session = req.getSession(false);
                        session.setAttribute("error", "Name or address more then 30 symbol");
                    }
                    break;
//                case "cinema update":
//                    Integer cinemaId = Integer.parseInt(req.getParameter("cinemaId"));
//                    cinema = cinemaService.getCinemaById(cinemaId);
//                    String newName = req.getParameter("newName");
//                    String newAddress = req.getParameter("newAddress");
//                    if (newName.length() <= 30){
//                        if (!newName.equals(null) && !newAddress.equals(null)){
//                            cinema.setName(newName);
//                            cinema.setAddress(newAddress);
//                            cinemaService.updateCinema(cinema);
//                            HttpSession session = req.getSession(false);
//                            session.setAttribute("error", "Cinema object was update");
//                        }else {
//                            HttpSession session = req.getSession(false);
//                            session.setAttribute("error", "Cinema name or address are empty");
//                        }
//                    }else {
//                        HttpSession session = req.getSession(false);
//                        session.setAttribute("error", "Cinema name or address more then 30 symbol");
//                    }
//                    break;
            }
        }

        model.addAttribute("user", getPrincipal());
        return modelAndView;
    }


    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
