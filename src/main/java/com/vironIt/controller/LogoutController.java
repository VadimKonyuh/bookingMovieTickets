package com.vironIt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout" , method = RequestMethod.POST)
    public String start(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    System.out.println("user=" + cookie.getValue());
                    break;
                }
            }
        }
        HttpSession session = req.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "redirect:/login";
    }
}
