package com.vironIt.db.dao;

import com.vironIt.entity.User;

import java.util.List;


public interface UserDAO {

    void addUser(User user);
    List<User> getUsers();
    User getById(Long id);
    void update(User user);
    void remove(Long id);
    User find(String name, String password);
}
