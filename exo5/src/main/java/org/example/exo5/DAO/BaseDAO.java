package org.example.exo5.DAO;

import org.example.exo5.util.HibernateSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public abstract class BaseDAO<T> {
    protected SessionFactory sessionFactory;
    protected Class<T> type;
    protected Session session;

    public BaseDAO(SessionFactory sessionFactory,Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public T save (T element){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(element);
        session.getTransaction().commit();
        session.close();
        return element;
    }

    public T getById (int id,Class<T> tClass){
        return session.find(tClass,id);
    }

    public T update (T element){
        try{
            session.getTransaction().begin();
            session.merge(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean delete (int id,Class<T> tClass){
        T elementFound = getById(id,tClass);
        if(elementFound != null){
            session.getTransaction().begin();
            session.remove(elementFound);
            session.getTransaction().commit();
            return true;
            }
        return false;
    }


}
