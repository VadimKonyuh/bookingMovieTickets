package com.vironIt.service;

import com.vironIt.db.dao.impl.UserDAOImplHibernate;
import com.vironIt.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {
    private UserDAOImplHibernate userDAOImplHibernate= new UserDAOImplHibernate();

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