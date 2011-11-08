package de.chkal.wjax11.web.details;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import de.chkal.wjax11.dao.BookDao;
import de.chkal.wjax11.model.Book;
import de.chkal.wjax11.web.cart.Cart;

@Named
@RequestScoped
@URLMapping(id = "book", pattern = "/buch/#{ bookBean.isbn }", viewId = "/faces/book.xhtml")
public class BookBean {

    private Long isbn;

    private Book book;

    @Inject
    private BookDao bookDao;

    @Inject
    private Cart cartBean;

    @URLAction
    public String loadData() {

        book = bookDao.getByIsbn(isbn);

        if (book == null) {
            PrettyContext.getCurrentInstance().sendError(404);
            return null;
        }

        return null;

    }

    public String addToCart() {

        // add book to cart
        cartBean.addBook(book);

        // REPLACE WITH "return null"
        return "pretty:book";

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
