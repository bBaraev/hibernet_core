package org.example.entity4;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String [] arg){
        createCar(new House("Bolnaya",140));
        createCar(new House("Varchakova",160));

    }

    public static void createCar(House house) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(house);
        session.getTransaction().commit();
        System.out.println("Successfully added " + house.getAddress());
        session.close();
    }

    public static House getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        House house = (House) session.get(House.class, id);
        session.getTransaction().commit();
        session.close();
        return house;
    }



    public static List<House> getAllHouse() {
        List<House> houses;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        houses = session.createQuery("FROM House").list();
        session.getTransaction().commit();
        session.close();
        return houses;
    }

    public static void updateHouse(Long id, String address, int square) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        House house = (House) session.get(House.class,id);
        house.setAddress(address);
        house.setSquare(square);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        House house = (House) session.get(House.class,id);
        session.delete(house);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM House");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in House");
    }
}
