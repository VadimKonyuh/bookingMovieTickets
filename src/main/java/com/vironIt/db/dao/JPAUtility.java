package com.vironIt.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
    private static final EntityManagerFactory emFactory;
    static {
        emFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
    }

    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }

    public static void clouse(){
        getEntityManager().close();
    }
}
