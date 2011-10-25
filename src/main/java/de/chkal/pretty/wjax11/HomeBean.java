package de.chkal.pretty.wjax11;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeBean {

    public Date getDate() {
        return new Date();
    }
    
}
