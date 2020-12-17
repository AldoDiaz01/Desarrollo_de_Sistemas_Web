package com.uv.empresaurios.dao;

import com.uv.empresaurios.model.Partido;
import com.uv.empresaurios.model.Presidente;
import java.util.List;
import com.uv.empresaurios.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PresidenteDao implements IDao<Presidente, Integer> {

    @Override
    public void insert(Presidente todo) {
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
    public Presidente find(Integer id) {
        Transaction transaction = null;

        Presidente todo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todo = session.get(Presidente.class, id);
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
    public List<Presidente> findAll() {
        Transaction transaction = null;

        List<Presidente> todos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todos = session.createQuery("from Presidente").getResultList();
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
            Presidente todo = null;
            todo = session.get(Presidente.class, id);
            session.delete(todo);
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
    public void update(Presidente todo) {
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

    public Partido findPartidoByName(String name) {
        Transaction transaction = null;

        List<Partido> todos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todos = session.createQuery("from Partido where nombre = '" + name + "'").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            if (todos.isEmpty()) {
                return null;
            }
            return todos.get(0);
        }
    }

}
