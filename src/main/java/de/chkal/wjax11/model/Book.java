package de.chkal.wjax11.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic
    private String title;

    @Basic
    private String author;

    @Basic
    private Long isbn;

    @Basic
    private Integer year;

    @Basic
    private Float price;

    @Basic
    @Column(name = "seo_key")
    private String seoKey;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Basic
    private Integer stock;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
