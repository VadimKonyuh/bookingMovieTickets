package com.konyuh.db.dao.impl;

import com.konyuh.db.dao.AbstractHibernateDAO;
import com.konyuh.utils.JPAUtility;
import com.konyuh.db.dao.UserDAOHibernate;
import com.konyuh.entity.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImplHibernate extends AbstractHibernateDAO<User, Long> implements UserDAOHibernate{

    public static final String HQL_FIND_USER_BY_LOGIN_PASSWORD = "FROM User user WHERE login =:paramLogin AND user.password =: paramPassword";
    public static final String HQL_REMOVE_USER_BY_ID = "DELETE FROM User WHERE User.id =: paramId";
    public static final String HQL_GET_USER_BY_LOGIN = "FROM User user WHERE login =: paramLogin";

    public UserDAOImplHibernate() {
        super(User.class);
    }

    @Override
    public User getUserByLoginPassword(String login, String passwod){
        EntityManager entityManager = JPAUtility.getEntityManager();
        Query query = entityManager.createQuery(HQL_FIND_USER_BY_LOGIN_PASSWORD);
        query.setParameter("paramLogin",login);
        query.setParameter("paramPassword",passwod);
        List<User> list = query.getResultList();
        User user;
        if (list.isEmpty()){
            user = new User();
        }else {
            user = list.get(0);
        }
        return user;
    }

    public User getUserByLogin(String login){
        EntityManager entityManager = JPAUtility.getEntityManager();
        Query query = entityManager.createQuery(HQL_GET_USER_BY_LOGIN);
        query.setParameter("paramLogin",login);
        List<User> list = query.getResultList();
        User user;
        if (list.isEmpty()){
            user = new User();
        }else {
            user = list.get(0);
        }
        return user;
    }
    public void removeUserById(Long id){
        EntityManager entityManager = JPAUtility.getEntityManager();
        Query query = entityManager.createQuery(HQL_REMOVE_USER_BY_ID);
        query.setParameter("paramId", id);
    }
}
