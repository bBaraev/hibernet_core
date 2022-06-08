package org.example.entity5;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main (String[] atg){
        create(new Teacher("Nurperi",20));
        create(new Teacher("Elnura",24));

    }

    public static void create(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        System.out.println("Successfully added " + teacher.getName());
        session.close();
    }

    public static Teacher getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacherc= (Teacher) session.get(Teacher.class,id);
        session.getTransaction().commit();
        session.close();
        return teacherc;
    }



    public static List<Teacher> getAll() {
        List<Teacher> teachers;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        teachers = session.createQuery("FROM Teacher").list();
        session.getTransaction().commit();
        session.close();
        return teachers;
    }

    public static void update(Long id, String name, int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = (Teacher) session.get(Teacher.class,id);
        teacher.setName(name);
        teacher.setAge(age);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = (Teacher) session.get(Teacher.class,id);
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Teacher");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all data,s in Teacher");
    }
}
