package org.example.entity;
import org.example.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class App {
    public static void main( String[] args ) {
        HibernateUtil.getSessionFactory();
        create(new Student("Berdibek",28));
        create(new Student("Bayaman",23));
        create(new Student("Timurlan",25));


    }

        public static void create(Student e) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            System.out.println("Added successfully " + e.getFirstName());
            session.close();
        }


            public static Student getById(Long id) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
               Student student = (Student) session.get(Student.class,id);
                session.getTransaction().commit();
                session.close();
                return student;
            }



            public static List<Student> getAllCars() {
                List<Student> students;
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                students = session.createQuery("FROM Student").list();
                session.getTransaction().commit();
                session.close();
                return students;
            }

            public static void updateStudent(Long id, String firstName,  int age) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Student student = (Student) session.get(Student.class,id);
                student.setFirstName(firstName);
                student.setAge(age);
                session.getTransaction().commit();
                session.close();
            }

            public static void deleteByID(long id) {
                Session session =  HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
               Student student = (Student) session.get(Student.class,id);
                session.delete(student);
                session.getTransaction().commit();
                session.close();
            }
            public static void deleteAll() {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("DELETE FROM Student");
                query.executeUpdate();
                session.getTransaction().commit();
                session.close();
                System.out.println("Successfully deleted all datas in Student");
            }
}

