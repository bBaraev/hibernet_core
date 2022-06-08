package org.example.entity6;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] arg) {
        createCar(new Cat("Mia", "sary"));
        createCar(new Cat("Maya", "ak"));

    }

    public static void createCar(Cat cat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
        System.out.println("Successfully added " + cat.getName());
        session.close();
    }

    public static Cat getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cat cat = (Cat) session.get(Cat.class, id);
        session.getTransaction().commit();
        session.close();
        return cat;
    }


    public static List<Cat> getAllCats() {
        List<Cat> cats;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cats = session.createQuery("FROM Cat").list();
        session.getTransaction().commit();
        session.close();
        return cats;
    }

    public static void updateCat(Long id, String name, String color) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cat cat = (Cat) session.get(Cat.class, id);
        cat.setName(name);
        cat.setColor(color);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cat cat = (Cat) session.get(Cat.class, id);
        session.delete(cat);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Cat");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data's in Cat");
    }
}
