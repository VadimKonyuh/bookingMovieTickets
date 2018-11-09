package dao;

import com.vironIt.db.dao.impl.CinemaDAOImpl;
import com.vironIt.entity.Cinema;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

public class TestDAOCinema {


    @Test
    public void getCinemaById() {
        Cinema cinema;
        CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
        cinema = cinemaDAO.find( 1);
        System.out.println(cinema);
//        cinema = cinemaDAO.getById(1);
//        System.out.println(cinema);
    }

    @Test
    public void createCinema(){
        Cinema cinema = new Cinema();
        cinema.setName("Аврора");
        cinema.setIsOpen(false);
        CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
        cinemaDAO.create(cinema);
    }

    @Test
    public void update(){
    Cinema cinema = new Cinema();
    cinema.setId(3);
    cinema.setName("SilverScreen");
    cinema.setIsOpen(true);
    CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
    cinemaDAO.update(cinema);
        System.out.println(cinema);
    }

    @Test
    public void delete(){
        Cinema cinema = new Cinema();
        cinema.setId(3);
        CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
        cinemaDAO.delete(cinema);
    }

    @Test
    public void findAll(){
        CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
        List<Cinema> cinemas = cinemaDAO.findAll();
        System.out.println(cinemas);
    }
}
