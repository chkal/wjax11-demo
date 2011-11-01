package de.chkal.wjax11.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;

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

    public Book getByIsbn(Long isbn) {
        try {
            return entityManager.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class)
                    .setParameter("isbn", isbn)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Book> findByQuery(String query) {
        return entityManager.createQuery(
                "SELECT b FROM Book b WHERE LOWER(b.title) LIKE :query OR LOWER(b.author) LIKE :query ORDER BY b.title", Book.class)
                .setParameter("query", "%" + query.toLowerCase() + "%")
                .getResultList();
    }

}
