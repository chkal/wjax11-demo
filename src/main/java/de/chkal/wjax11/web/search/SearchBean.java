package de.chkal.wjax11.web.search;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLQueryParameter;

import de.chkal.wjax11.dao.BookDao;
import de.chkal.wjax11.model.Book;

@Named
@RequestScoped
@URLMapping(id = "search", pattern = "/suchen", viewId = "/faces/search.xhtml")
public class SearchBean {

    // ANNOTATION ENTFERNEN
    @URLQueryParameter("q")
    private String query;

    private List<Book> books;

    @Inject
    private BookDao bookDao;
    
    // ANNOTATION ENTFERNEN
    @URLAction
    public void search() {
        if(query != null && query.trim().length() > 0) {
            books = bookDao.findByQuery(query);
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Book> getBooks() {
        return books;
    }

}
