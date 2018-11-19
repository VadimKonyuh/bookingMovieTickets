package com.vironIt.service;

import com.vironIt.db.dao.impl.CinemaDAOImpl;
import com.vironIt.entity.Cinema;

public class CinemaService {
    private CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();

    public CinemaService(){}

    public void addCinema(Cinema cinema){
        this.cinemaDAO.create(cinema);
    }

    public void deleteCinemaById(Integer id){
        this.cinemaDAO.deleteCinemaById(id);
    }

    public Cinema getCinemaByName(String name){
        return this.cinemaDAO.findCinemaByName(name);
    }

    public Cinema getCinemaByNameAddress(String name, String address){return this.cinemaDAO.findCinemaByNameAddress(name, address);}

    public void updateCinema(Cinema cinema){
        this.cinemaDAO.update(cinema);
    }
}
