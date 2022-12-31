package com.repository;

import com.domain.Calculation;
import com.domain.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalculationRepository {
    private SessionFactory sessionFactory;

    public  CalculationRepository(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}

    public Calculation create(Calculation calculation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(calculation);
        return calculation;
    }
    public Calculation get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Calculation.class, id);
    }
}
