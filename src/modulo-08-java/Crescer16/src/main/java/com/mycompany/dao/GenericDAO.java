package com.mycompany.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.interfaces.IGenericDAO;
import com.mycompay.entity.Cidade;
import javax.persistence.EntityTransaction;

public class GenericDAO<T> implements IGenericDAO<T> {
    @PersistenceContext
    private final EntityManager em;
    private final Class<T> persistentClass;
    private final EntityTransaction transaction;
    
    public GenericDAO(Class<T> typeParameterClass) {
        this.persistentClass = typeParameterClass;
        this.em = EntityManagerUtils.createEntityManager();
        this.transaction = em.getTransaction();
    }
    
    @Override
    public void insert(Object entity) {
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Object entity) {
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(Object entity) {
        transaction.begin();
        em.remove(em.merge(entity));
        transaction.commit();
    }

    @Override
    public List<T> listAll() {
        return em.createQuery(String.format("SELECT t FROM %s t", persistentClass.getSimpleName())).getResultList();
    }
}
