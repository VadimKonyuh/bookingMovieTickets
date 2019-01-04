package dao.hibernate;

import com.konyuh.db.dao.impl.CinemaDAOImplHibernate;
import com.konyuh.entity.Cinema;
import org.junit.Before;
import org.junit.Test;

public class TestCinemaDAOTest {
    CinemaDAOImplHibernate cinemaDAOImplHibernate;
    Cinema cinema;

    @Before
    public void initialize(){
        cinemaDAOImplHibernate = new CinemaDAOImplHibernate();
        cinema = new Cinema();
        cinema.setName("testName");
        cinema.setAddress("testAddress");
    }

    @Test
    public void getCinemaByName(){
        System.out.println(cinemaDAOImplHibernate.findCinemaByName("Raketa13"));
    }

    @Test
    public void getCinemaByNameAddress(){
        System.out.println(cinemaDAOImplHibernate.findCinemaByNameAddress("Cinema", "new Address"));;
    }

    @Test
    public void create(){
//        cinemaDAOImplHibernate.create(cinema);
        Cinema cinema = null;
        System.out.println(cinema != null);
        String s = "null";
        System.out.println(s.equals(null));
    }



}