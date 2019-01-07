package com.konyuh.service;

import com.konyuh.db.dao.impl.UserDAOImplHibernate;
import com.konyuh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    @Autowired
    private UserDAOImplHibernate userDAOImplHibernate;

    public UserService(){

    }

    public void addUser(User user){
        this.userDAOImplHibernate.create(user);
    }

    public void updateUser(User user){
        this.userDAOImplHibernate.update(user);
    }

    public List<User> getUsers(){
        return  this.userDAOImplHibernate.findAll();
    }

    public void removeUser(Long id){
        this.userDAOImplHibernate.removeUserById(id);
    }

    public User getUserById(Long id){
        return this.userDAOImplHibernate.findById(id);
    }

    public User getUserByLoginPassword(String login, String password){
        return this.userDAOImplHibernate.getUserByLoginPassword(login, password);
    }

    public User getUserByLogin(String login){
        return this.userDAOImplHibernate.getUserByLogin(login);
    }
}