package org.example.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        try {

            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            return sessionFactory;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }

    }
}
