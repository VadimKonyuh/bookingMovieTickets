package com.konyuh.db.dao.impl;

import com.konyuh.db.dao.AbstractHibernateDAO;
import com.konyuh.db.dao.CinemaDAOHibernate;
import com.konyuh.utils.JPAUtility;
import com.konyuh.entity.Cinema;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CinemaDAOImplHibernate extends AbstractHibernateDAO<Cinema, Integer> implements CinemaDAOHibernate{

    public static final String HQL_FIND_CINEMA_BY_Name = "FROM Cinema cinema WHERE name =:paramName";
    public static final String HQL_FIND_CINEMA_BY_NAME_ADDRESS = "FROM Cinema cinema WHERE name =:paramName AND address =: paramAddress";

    public CinemaDAOImplHibernate() {
        super(Cinema.class);
    }

    public Cinema findCinemaByName(String cinemaName){
        EntityManager entityManager = JPAUtility.getEntityManager();
        Query query = entityManager.createQuery(HQL_FIND_CINEMA_BY_Name);
        query.setParameter("paramName",cinemaName);
        List<Cinema> list = query.getResultList();
        Cinema cinema;
        if (list != null) {
            cinema = list.get(0);
        }else {
            cinema = null;
        }
        return cinema;
    }

    public Cinema findCinemaByNameAddress(String cinemaName, String cinemaAddress){
        EntityManager entityManager = JPAUtility.getEntityManager();
        Query query = entityManager.createQuery(HQL_FIND_CINEMA_BY_NAME_ADDRESS);
        query.setParameter("paramName",cinemaName);
        query.setParameter("paramAddress",cinemaAddress);
        List<Cinema> list = query.getResultList();
        Cinema cinema;
        if (list != null){
            cinema = list.get(0);
        }else {
            cinema = new Cinema();
        }
        return cinema;
    }
}
