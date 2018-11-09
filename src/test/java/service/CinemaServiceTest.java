package service;

import com.vironIt.entity.Cinema;
import com.vironIt.service.CinemaService;
import org.junit.Test;

public class CinemaServiceTest {

    @Test
    public void addCinema(){
        CinemaService cinemaService = new CinemaService();
        Cinema cinema = new Cinema();
        cinema.setName("фывы");
        cinema.setAddress("фывы");
        cinema.setIsOpen(true);
        System.out.println(cinema);
        cinemaService.addCinema(cinema);

    }
}
