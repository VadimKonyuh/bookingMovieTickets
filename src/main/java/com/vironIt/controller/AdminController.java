package com.vironIt.controller;

import com.vironIt.db.dao.impl.CinemaDAOImplHibernate;
import com.vironIt.entity.Cinema;
import com.vironIt.entity.User;
import com.vironIt.entity.enums.Role;
import com.vironIt.service.CinemaService;
import com.vironIt.service.UserService;
import lombok.extern.log4j.Log4j;
import org.mortbay.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class AdminController {

    private static final String REGEX_LOGIN = "^[а-яА-ЯёЁa-zA-Z0-9]+$";
    private static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @GetMapping("/")
    public String start(){
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        Log.debug("name");
        System.out.println("Name");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String registration(HttpServletRequest req,
                               HttpServletResponse resp){
        Log.debug("/login, method POST");
        Log.debug("login: " + req.getParameter("login"));
        Log.debug("login: " + req.getParameter("password"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String error = "";
        String page;
        UserService userService = new UserService();
        User user = userService.getUserByLoginPassword(login, password);
        if (login.equals(user.getLogin()) && password.equals(user.getPassword())){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("error", "");
            session.setMaxInactiveInterval(30 * 60);
            Cookie loginCookie = new Cookie("login", login);
            loginCookie.setMaxAge(30*60);
            resp.addCookie(loginCookie);
            req.setAttribute("name", login);
            if (user.getRole().toString().toLowerCase().equals("admin")){
                page = "redirect:/admin";
            }else {
                page = "user";
            }
        }else{
            error = "You entered an incorrect username or password";
            req.setAttribute("error", error);
            page = "login";
        }
        return page;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet(@ModelAttribute("name") String name,  Model model){
        System.out.println(name);
        System.out.println("Name");
        String page = "registration";
        return page;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(HttpServletRequest req, HttpServletResponse resp,
                                   @ModelAttribute("name") String name,  Model model){
        String error = "";
        String page = "";
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
        user.setRole(Role.USER);
        UserService userService = new UserService();
        if(!login.isEmpty()){
            Pattern p = Pattern.compile(REGEX_LOGIN);
            Matcher m = p.matcher(login);
            if (m.matches() && login.length() <= 30){
                p = Pattern.compile(REGEX_PASSWORD);
                m = p.matcher(password);
                if (m.matches()){
                    if (password.equals(password1) && login.length() > 4){
                        System.out.println(login.length());
                        userService.addUser(user);
                        req.setAttribute("user", user);
                        req.setAttribute("name", login);
                        page = "user";
//                        req.getRequestDispatcher("user.jsp").forward(req, resp);
                    }else {
                        req.setAttribute("error", "login < 5 or Passwords do not match");
                        req.setAttribute("login", login);
                        req.setAttribute("password", password);
                        req.setAttribute("password1", password1);
                        page = "registration";
//                        req.getRequestDispatcher("registration.jsp").forward(req, resp);
                    }
                }else {
                    req.setAttribute("error","incorrect password");
                    req.setAttribute("login", login);
                    req.setAttribute("password", password);
                    page = "registration";
//                    req.getRequestDispatcher("registration.jsp").forward(req, resp);
                }
            }else {
                error = "incorrect login";
                req.setAttribute("error", error);
                page = "registration.jsp";
//                req.getRequestDispatcher(page).forward(req, resp);
            }
        }
        System.out.println(name);
        System.out.println("Name");
        return page;
    }
//    @RequestMapping(value = "/")

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(HttpServletRequest req, @ModelAttribute("login") String login, Model model) {
        model.addAttribute("someAttribute", "someValue");
        System.out.println(login);
        String name = "";
        String page = "";
        String[] id = req.getParameterValues("cinemaId");
        String select[] = req.getParameterValues("cinemaId");
        if (select != null && select.length != 0) {
            CinemaService cinemaService = new CinemaService();
            for (int i = 0; i < select.length; i++) {
                cinemaService.deleteCinemaById(Integer.parseInt(select[i]));
//                log("You are delete " + select[i]);
            }
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String error = (String) session.getAttribute("error");
        if (user != null && user.getLogin() != null){
            name = user.getLogin();
            CinemaDAOImplHibernate cinemaDAOImplHibernate = new CinemaDAOImplHibernate();
            List<Cinema> cinemaList = cinemaDAOImplHibernate.findAll();
            req.setAttribute("CinemaList",cinemaList);
            req.setAttribute("name", name);
            page = "admin";
//            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        }else{
            req.setAttribute("error", "session is ended");
            page = "redirect:/login";
//            req.getRequestDispatcher("/login").forward(req, resp);
        }
        return page;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String adminPost(HttpServletRequest req, @ModelAttribute("login") String login, Model model){
        String page = "redirect:/admin";
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
        return page;
    }
}
