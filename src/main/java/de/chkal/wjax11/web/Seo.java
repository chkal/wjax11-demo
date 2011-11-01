package de.chkal.wjax11.web;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("seo")
@ApplicationScoped
public class Seo {
    
    public String escape(String s) {
        return s.trim().replace(" ", "_");
    }

}
