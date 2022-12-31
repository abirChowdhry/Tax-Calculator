package com.repository;

import com.domain.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;

@Repository
public class AdminRepository {

    private SessionFactory sessionFactory;

    public AdminRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Admin> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Admin> studentQuery = session.createQuery("from Admin", Admin.class);
        return studentQuery.getResultList();
    }

    public boolean create(Admin admin) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(admin);
        return true;
    }

    public Admin get(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Admin.class, id);
    }

}

