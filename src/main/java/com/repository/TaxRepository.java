package com.repository;

import com.domain.Tax;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TaxRepository {

    private SessionFactory sessionFactory;

    public  TaxRepository(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}

    public Tax create(Tax tax) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tax);
        return tax;
    }


}
