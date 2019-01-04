package com.konyuh.db.dao;

import com.konyuh.entity.User;

public interface UserDAOHibernate extends BaseDAO<User, Long> {

    User getUserByLoginPassword(String name, String password);
}
