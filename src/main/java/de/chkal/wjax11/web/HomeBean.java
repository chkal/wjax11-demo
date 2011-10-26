package de.chkal.wjax11.web;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.chkal.wjax11.dao.ProductDao;

@Named
@RequestScoped
public class HomeBean {

    @Inject
    private ProductDao productDao;
    
    public Date getDate() {
        return new Date();
    }
    
    public long getCount() {
        return productDao.count();
    }
    
}
