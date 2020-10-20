package com.empresaurios.crud.dao;

import com.empresaurios.crud.model.Auto;

import java.util.List;

import com.empresaurios.crud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AutoDao implements IDao<Auto, Integer> {

    @Override
    public void insert(Auto todo) {
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
    public Auto selectById(Integer id) {
        Transaction transaction = null;

        Auto todo = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todo = session.get(Auto.class, id);
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
    public List<Auto> select() {
        Transaction transaction = null;

        List<Auto> todos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            todos = session.createQuery("from Auto").getResultList();
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
            session.delete(new Auto(id, null, null, null));
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
    public void update(Auto todo) {
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
