package com.vironIt.db.dao;

import java.util.List;

public interface BaseDAO<T> {

    T findById(long id);
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
