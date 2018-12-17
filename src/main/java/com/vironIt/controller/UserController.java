package com.vironIt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String lo(@ModelAttribute("name") String name, Model model){
        System.out.println(name);
        System.out.println("Name");
        return "user";
    }
}
