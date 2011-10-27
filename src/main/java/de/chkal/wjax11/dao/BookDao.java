package de.chkal.wjax11.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import de.chkal.wjax11.model.Book;
import de.chkal.wjax11.model.Category;

@ApplicationScoped
public class BookDao extends AbstractDao<Book> {

    @Override
    public Class<Book> getEntityClass() {
        return Book.class;
    }
    
    public List<Book> findByCategory(Category category) {
        return entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.category = :category ORDER BY b.title", Book.class)
                .setParameter("category", category)
                .getResultList();
    }

}
