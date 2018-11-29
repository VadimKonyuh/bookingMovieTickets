package com.vironIt.db.dao;

import com.vironIt.entity.User;

public interface UserDAOHibernate extends BaseDAO<User> {

    User getUserByLoginPassword(String name, String password);
}
