package de.chkal.wjax11.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @Basic
    private String name;
    
    @Basic
    @Column(name="seo_key")
    private String seoKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoKey() {
        return seoKey;
    }

    public void setSeoKey(String seoName) {
        this.seoKey = seoName;
    }
    
}
