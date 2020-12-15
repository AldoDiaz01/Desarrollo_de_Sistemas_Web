package com.uv.empresaurios.dao;

import com.uv.empresaurios.model.Usuario;
import com.uv.empresaurios.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UsuarioDao {

    public Usuario verificarDatos(Usuario usuario) {
        Usuario usuarioVerificado = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Usuario WHERE email = '" + usuario.getEmail()
                    + "' AND clave = '" + usuario.getClave() + "'";
            Query query = session.createQuery(hql);

            if (!query.list().isEmpty()) {
                usuarioVerificado = (Usuario) query.list().get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return usuarioVerificado;
        }
    }

    public void registry(Usuario todo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(todo);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

}
