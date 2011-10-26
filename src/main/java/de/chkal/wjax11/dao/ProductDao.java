package de.chkal.wjax11.dao;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductDao extends AbstractDao {

    public long count() {
        return entityManager.createQuery("SELECT COUNT(e) FROM Product e", Long.class).getSingleResult();
    }
    
}
