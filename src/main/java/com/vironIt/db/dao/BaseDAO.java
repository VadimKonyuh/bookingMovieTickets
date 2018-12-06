package com.vironIt.db.dao;

import java.util.List;

public interface BaseDAO<T, K extends Number> {

    T findById(K id);
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
