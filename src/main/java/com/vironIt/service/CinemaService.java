package com.vironIt.service;

import com.vironIt.db.dao.CinemaDAO;
import com.vironIt.db.dao.impl.CinemaDAOImpl;
import com.vironIt.entity.Cinema;

public class CinemaService {
    private CinemaDAO cinemaDAO = new CinemaDAOImpl();

    public CinemaService(){
    }

    public void addCinema(Cinema cinema){
        this.cinemaDAO.create(cinema);
    }
}
