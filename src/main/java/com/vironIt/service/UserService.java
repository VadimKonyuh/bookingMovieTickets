package com.vironIt.service;

import com.vironIt.db.dao.UserDAO;
import com.vironIt.db.dao.impl.UserDAOImpl;
import com.vironIt.entity.User;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public UserService(){}

    public void addUser(User user){this.userDAO.addUser(user); }

    public void updateUser(User user){
        this.userDAO.update(user);
    }

    public List<User> getUsers(){ return this.userDAO.getUsers();}

    public void removeUser(Long id){
        this.userDAO.remove(id);
    }

    public User getUserById(Long id){ return this.userDAO.getById(id);}

    public User getUserByLoginPassword(String name, String password){return this.userDAO.getUserByLoginPassword(name, password);}
}
