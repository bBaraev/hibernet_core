package org.example.entity8;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


import java.util.List;

public class App {
    public static void main(String [] arg){
        createPhone(new Phone("Oppo",22000));
        createPhone(new Phone("Samsung A 30",25000));

    }
    public static void createPhone(Phone phone){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
        session.close();
    }
    public static Phone getById(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.get(Phone.class,id);
        session.getTransaction().commit();
        session.close();
    return phone;
    }
    public static List<Phone>getAllPhone(){
        List<Phone>phones;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        phones= session.createQuery("FROM Phone").list();
        session.getTransaction().commit();
        session.close();
        return phones;
    }
    public static void updatePone(long id,String name , int price){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.get(Phone.class,id);
        phone.setName(name);
        phone.setPrice(price);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteById(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = (Phone) session.get(Phone.class,id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Phone");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }



}
