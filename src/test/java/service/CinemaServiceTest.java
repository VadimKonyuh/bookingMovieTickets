package service;

import com.konyuh.entity.Cinema;
import com.konyuh.service.CinemaService;
import org.junit.Before;
import org.junit.Test;

public class CinemaServiceTest {

    private CinemaService cinemaService;
    private Cinema cinema;

    @Before
    public void createService(){
        cinemaService = new CinemaService();
        cinema = new Cinema();
    }

    @Test
    public void addCinema(){
        cinema.setName("фывы");
        cinema.setAddress("фывы");
        System.out.println(cinema);
        cinemaService.addCinema(cinema);
    }

    @Test
    public void getCinemaByName(){
        cinema = cinemaService.getCinemaByName("Аврора");
        System.out.println(cinema);
    }

    @Test
    public void getCinemaByNameAddress(){
        cinema = cinemaService.getCinemaByNameAddress("vadim", "vadim");
        System.out.println(cinema);
    }

    @Test
    public void updateCinema(){
        cinema.setId(16);
        cinema.setName("vadim");
        cinemaService.updateCinema(cinema);
    }

}
