package com.vironIt.controller;

import com.vironIt.entity.User;
import com.vironIt.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getEmployees() {
        UserService userService = new UserService();
        List<User> list = userService.getUsers();
        return list;
    }
}
