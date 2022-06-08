package org.example.entity7;

import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[]arg){
        create(new Notebook("Macbook pro 13",13000));
        create(new Notebook("Huawei",12000));

    }

    public static void create(Notebook notebook) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(notebook);
        session.getTransaction().commit();
        System.out.println("Successfully added " + notebook.getName());
        session.close();
    }

    public static Notebook getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Notebook notebook = (Notebook) session.get(Notebook.class,id);
        session.getTransaction().commit();
        session.close();
        return notebook;
    }



    public static List<Notebook> getAll() {
        List<Notebook> notebooks;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        notebooks = session.createQuery("FROM Notebook").list();
        session.getTransaction().commit();
        session.close();
        return notebooks;
    }

    public static void update(Long id, String name, int price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Notebook notebook = (Notebook) session.get(Notebook.class,id);
       notebook.setName(name);
       notebook.setPrice(price);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Notebook notebook = (Notebook) session.get(Notebook.class,id);
        session.delete(notebook);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Notebook");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data's in Notebook");
    }
}
