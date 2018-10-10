package com.vironIt.service;

import com.vironIt.db.dao.UserDAO;
import com.vironIt.db.dao.UserDAOImpl;
import com.vironIt.entity.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public UserService(){
    }

    public void addUser(User user){
        this.userDAO.addUser(user);
    }

    public List<User> getUsers(){
        return this.userDAO.getUsers();
    }

}
