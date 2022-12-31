package com.repository;

import com.domain.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    private SessionFactory sessionFactory;

    public  CategoryRepository(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}

    public Category create(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
        return category;
    }

    public Category get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    public Category update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        return category;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = get(id);
        if (category != null) {
            session.delete(category);
        }
    }

    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> userQuery = session.createQuery("from Category ", Category.class);
        return userQuery.getResultList();
    }
}
