package com.konyuh.controller;

import com.konyuh.entity.User;
import com.konyuh.exception.OrderNotFoundException;
import com.konyuh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        List<User> list = userService.getUsers();
        return list;
    }

    @RequestMapping(value = "/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        if (user == null) throw new OrderNotFoundException(id + "");
        return user;
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        try {
            userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.PUT)
    public User createUser(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        userService.removeUser(id);
        return user;
    }
}
