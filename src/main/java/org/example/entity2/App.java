package org.example.entity2;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main( String [] arg ){
        createDogs(new Dog("Alabay","black"));
        createDogs(new Dog("Aktosh","white"));
        System.out.println(getById(2l));
        System.out.println(getAllDogs());
        updateDogs(1l,"Alaby","black");
        deleteByID(1l);
        deleteAll();

    }
    public static void createDogs(Dog d){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            session.save(d);
            session.getTransaction().commit();
            System.out.println("Successfully added "+ d.getNameDog());
            session.close();
        }

    public static Dog getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog = (Dog) session.get(Dog.class,id);
        session.getTransaction().commit();
        session.close();
        return dog;
    }



    public static List<Dog> getAllDogs() {
        List<Dog> dogs;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        dogs = session.createQuery("FROM Dog").list();
        session.getTransaction().commit();
        session.close();
        return dogs;
    }

    public static void updateDogs(Long id, String name, String color) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog= (Dog) session.get(Dog.class,id);
        dog.setNameDog(name);
        dog.setColor(color);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog = (Dog) session.get(Dog.class,id);
        session.delete(dog);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Dog");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data,s in Dog");
    }
    }

