package com.vironIt.service;

import com.vironIt.db.dao.impl.CinemaDAOImplHibernate;
import com.vironIt.entity.Cinema;

public class CinemaService {
    private CinemaDAOImplHibernate cinemaDAOImplHibernate = new CinemaDAOImplHibernate();

    public CinemaService(){

    }

    public void addCinema(Cinema cinema){
        this.cinemaDAOImplHibernate.create(cinema);
    }

    public void deleteCinemaById(Integer id){
        Cinema cinema = cinemaDAOImplHibernate.findById(id);
        cinemaDAOImplHibernate.delete(cinema);
    }

    public Cinema getCinemaById(Integer id){
        return this.cinemaDAOImplHibernate.findById(id);
    }

    public Cinema getCinemaByName(String name){
        return this.cinemaDAOImplHibernate.findCinemaByName(name);
    }

    public Cinema getCinemaByNameAddress(String name, String address){
        return this.cinemaDAOImplHibernate.findCinemaByNameAddress(name, address);
    }

    public void updateCinema(Cinema cinema){
        this.cinemaDAOImplHibernate.update(cinema);
    }
}
