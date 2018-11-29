package com.vironIt.db.dao;


import javax.persistence.EntityManager;
import java.util.List;


public abstract class AbstractHibernateDAO<T> {
    private Class entityClass;
    private EntityManager entityManager;

    protected AbstractHibernateDAO(Class entityClass) {
        setEntityClass(entityClass);
    }

    private void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(long id) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        T t = (T) entityManager.find(entityClass,(int) id);
        entityManager.getTransaction().commit();
        return t;
    }

    public void create(T entity) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(T entity) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        entityManager.getTransaction().commit();
    }

    public List<T> findAll() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        List<T> entities = entityManager.createQuery("from " + entityClass.getName()).getResultList();
        entityManager.getTransaction().commit();
        return entities;
    }
}