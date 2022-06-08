package org.example.entity1;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[]arg){


        createDriver(new Driver("Samat","Baganov",25));
        createDriver(new Driver("Muhamed","Almazbekov",25));
        createDriver(new Driver("Timurlan","Kasymabaev",25));

    }
    public static void createDriver(Driver d){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            session.save(d);
            session.getTransaction().commit();
            System.out.println("Successfully addad" + d.getFirstName());
            session.close();
        }

    public static Driver getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Driver driver = (Driver) session.get(Driver.class,id);
        session.getTransaction().commit();
        session.close();
        return driver;
    }



    public static List<Driver> getAllDriver() {
        List<Driver> drivers;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        drivers = session.createQuery("FROM Driver").list();
        session.getTransaction().commit();
        session.close();
        return drivers;
    }

    public static void updateDriver(Long id, String firstName, String lastName,int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Driver driver = (Driver) session.get(Driver.class,id);
        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driver.setAge(age);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Driver driver = (Driver) session.get(Driver.class,id);
        session.delete(driver);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Driver");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data's in Driver");
    }

    }

