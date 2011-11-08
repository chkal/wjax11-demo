package de.chkal.wjax11.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import de.chkal.wjax11.dao.CategoryDao;
import de.chkal.wjax11.model.Category;

@Named
@RequestScoped
// TODO: REMOVE ANNOTATION
@URLMapping(id = "home", pattern = "/home", viewId = "/faces/home.xhtml")
public class HomeBean {

    @Inject
    private CategoryDao categoryDao;

    private List<Category> categories;

    // TODO: REMOVE COMPLETE METHOD
    @URLAction
    public void loadData() {
        categories = categoryDao.list();
    }

    public List<Category> getCategories() {
        return categories;
    }

}
