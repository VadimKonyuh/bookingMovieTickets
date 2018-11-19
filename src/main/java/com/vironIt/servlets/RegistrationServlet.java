package com.vironIt.servlets;


import com.vironIt.entity.User;
import com.vironIt.entity.enums.Role;
import com.vironIt.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
public class RegistrationServlet extends HttpServlet{

    public static final String REGEX_LOGIN = "^[а-яА-ЯёЁa-zA-Z0-9]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        if(!login.equals(null)){
            Pattern p = Pattern.compile(REGEX_LOGIN);
            Matcher m = p.matcher(login);
            if (m.matches()){
                p = Pattern.compile(REGEX_PASSWORD);
                m = p.matcher(password);
                if (m.matches()){
                    if (password.equals(password1) && login.length() > 4){
                        System.out.println(login.length());
                        userService.addUser(user);
                        req.setAttribute("user", user);
                        req.setAttribute("name", login);
                        log("redirect to  user.jsp from registration.jsp");
                        req.getRequestDispatcher("user.jsp").forward(req, resp);
                    }else {
                        req.setAttribute("error", "login < 5 or Passwords do not match");
                        req.setAttribute("login", login);
                        req.setAttribute("password", password);
                        req.setAttribute("password1", password1);
                        req.getRequestDispatcher("registration.jsp").forward(req, resp);
                    }
                }else {
                    req.setAttribute("error","incorrect password");
                    req.setAttribute("login", login);
                    req.setAttribute("password", password);
                    req.getRequestDispatcher("registration.jsp").forward(req, resp);
                }
            }else {
                error = "incorrect login";
                req.setAttribute("error", error);
                page = "registration.jsp";
                req.getRequestDispatcher(page).forward(req, resp);
            }
        }
    }
}
