package com.vironIt.db.dao;

import com.vironIt.entity.User;

import java.util.List;


public interface UserDAO {

    void addUser(User user);
    List<User> getUsers();
}
