package de.chkal.wjax11.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import de.chkal.wjax11.dao.BookDao;
import de.chkal.wjax11.model.Book;

@Named
@RequestScoped
@URLMapping(id = "book", pattern = "/buch/#{bookBean.isbn}", viewId = "/faces/book.xhtml")
public class BookBean {

    private Long isbn;

    private Book book;

    @Inject
    private BookDao bookDao;

    @URLAction
    public void init() {

        book = bookDao.getByIsbn(isbn);
        if (book == null) {
            PrettyContext.getCurrentInstance().sendError(404);
            return;
        }

    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Book getBook() {
        return book;
    }

}
