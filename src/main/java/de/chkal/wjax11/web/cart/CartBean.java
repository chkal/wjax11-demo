package de.chkal.wjax11.web.cart;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import de.chkal.wjax11.model.Book;

@Named
@RequestScoped
@URLMapping(id = "cart", pattern = "/warenkorb", viewId = "/faces/cart.xhtml")
public class CartBean {

    @Inject
    private Cart cart;

    private List<Book> books;

    private float sum;

    @URLAction
    public void init() {

        books = cart.getBooks();

        sum = 0.0f;
        for (Book book : books) {
            sum += book.getPrice();
        }

    }

    public List<Book> getBooks() {
        return books;
    }

    public float getSum() {
        return sum;
    }

}
