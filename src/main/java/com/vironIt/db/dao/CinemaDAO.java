package com.vironIt.db.dao;

import com.vironIt.entity.Cinema;

import java.util.List;

public interface CinemaDAO  {

     Cinema find(Integer id);

     void create(Cinema cinema);
     void update(Cinema cinema);
     void delete(Cinema cinema);
     List<Cinema> findAll();
}
