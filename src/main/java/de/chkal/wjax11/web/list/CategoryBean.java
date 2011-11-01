package de.chkal.wjax11.web.list;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import de.chkal.wjax11.dao.BookDao;
import de.chkal.wjax11.dao.CategoryDao;
import de.chkal.wjax11.model.Book;
import de.chkal.wjax11.model.Category;

@Named
@RequestScoped
@URLMapping(id = "category", pattern = "/kategorie/#{categoryBean.seoKey}", viewId = "/faces/category.xhtml")
public class CategoryBean {

    private String seoKey;

    @Inject
    private CategoryDao categoryDao;

    @Inject
    private BookDao bookDao;

    private List<Book> books;

    @URLAction
    public String init() {

        Category category = categoryDao.getBySeoKey(seoKey);
        
        if (category == null) {

            return "pretty:home";
            
            // alternative:
            /*
            PrettyContext.getCurrentInstance().sendError(404);
            return null;
             */
            
        }

        books = bookDao.findByCategory(category);
        
        return null;

    }

    public List<Book> getBooks() {
        return books;
    }

    public String getSeoKey() {
        return seoKey;
    }

    public void setSeoKey(String seoKey) {
        this.seoKey = seoKey;
    }

}
