package org.example.entity9;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[]arg){
        create(new Cook("Aibek",800000));
        create(new Cook("Myktybek",700000));

    }
    public static void create(Cook cook){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cook);
        session.getTransaction().commit();
        session.close();
    }
    public static Cook getById(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cook cook = (Cook) session.get(Cook.class,id);
        session.beginTransaction().commit();
        session.close();
        return cook;
    }
    public static List<Cook>getAllCook(){
        List<Cook>cooks;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cooks = session.createQuery("FROM Cook").list();
        session.getTransaction().commit();
        session.close();
        return cooks;
    }
    public static void updateCook(long id,String name , int salary){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cook cook = (Cook) session.get(Cook.class,id);
        cook.setName(name);
        cook.setSalary(salary);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteById(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Cook cook = (Cook) session.get(Cook.class,id);
        session.delete(cook);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Cook");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
