package org.example.exo5.DAO;

import org.example.exo5.entity.Dog;
import org.example.exo5.util.HibernateSession;

import java.util.ArrayList;
import java.util.List;

public class DogDAO extends BaseDAO<Dog> {
    public DogDAO() {
        super(HibernateSession.getSessionFactory(), Dog.class);
    }



    public List<Dog> getAllDog() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select c from Dog c", Dog.class).getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }
}
