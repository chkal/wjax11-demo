package de.chkal.wjax11.web.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.chkal.wjax11.model.Book;

@Named
@SessionScoped
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<Book> books = new ArrayList<Book>();
    
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
    
    public int getNumberOfBooks() {
        return books.size();
    }

}
