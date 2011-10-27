package de.chkal.wjax11.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book extends AbstractEntity {

    @Basic
    private String title;
    
    @Basic
    private Long isbn;
    
    @Basic
    @Column(name="seo_key")
    private String seoKey;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public String getSeoKey() {
        return seoKey;
    }

    public void setSeoKey(String seoName) {
        this.seoKey = seoName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
    
}
