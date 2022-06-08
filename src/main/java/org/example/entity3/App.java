package org.example.entity3;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] arg) {
//        createCar(new Car("BMW", 2.5));
//        createCar(new Car("AUDI", 2.8));
//        System.out.println(getById(1L));
//        System.out.println(getAllUsers());
//        updateCar(2l ,"AUDI",2.9);
//        deleteByID(3);
        deleteAll();
    }

    public static void createCar(Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        System.out.println("Successfully added " + car.getNameCar());
        session.close();
    }

    public static Car getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = (Car) session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }



    public static List<Car> getAllCars() {
        List<Car> cars;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cars = session.createQuery("FROM Car").list();
        session.getTransaction().commit();
        session.close();
        return cars;
    }

    public static void updateCar(Long id, String name, double volume) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = (Car) session.get(Car.class, id);
        car.setNameCar(name);
        car.setVolume(volume);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = (Car) session.get(Car.class, id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Car");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Car");
    }


}

