
package com.uv.empresaurios.dao;
import com.uv.empresaurios.model.Partido;
import java.util.List;
import com.uv.empresaurios.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PartidoDao implements IDao<Partido, Integer>{

    @Override
    public void insert(Partido todo) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(todo);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Partido find(Integer id) {
        Transaction transaction = null;

        Partido todo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todo = session.get(Partido.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return todo;
        }
    }

    @Override
    public List<Partido> findAll() {
        Transaction transaction = null;

        List<Partido> todos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todos = session.createQuery("from Partido").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return todos;
        }
    }

    @Override
    public boolean delete(Integer id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(String.valueOf(id), Partido.class);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return false;
        }
    }

    @Override
    public void update(Partido todo) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(todo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
