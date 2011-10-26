package de.chkal.wjax11.dao;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao {

    @Inject
    private DataLoader dataLoader;

    @PersistenceContext
    protected EntityManager entityManager;

    @PostConstruct
    public void init() {
        dataLoader.checkDatabaseInitialized();
    }

}
