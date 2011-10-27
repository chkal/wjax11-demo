package de.chkal.wjax11.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<E> {

    @Inject
    private DataLoader dataLoader;

    @PersistenceContext
    protected EntityManager entityManager;

    public abstract Class<E> getEntityClass();
    
    public String getEntityName() {
        return getEntityClass().getSimpleName();
    }
    
    @PostConstruct
    public void init() {
        dataLoader.checkDatabaseInitialized();
    }
    
    public List<E> list() {
        return entityManager.createQuery("SELECT e FROM "+getEntityName()+" e", getEntityClass()).getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM "+getEntityName()+" e", Long.class).getSingleResult();
    }
    
}
