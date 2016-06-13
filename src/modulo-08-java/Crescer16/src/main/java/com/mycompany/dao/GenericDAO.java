package com.mycompany.dao;

import JPAUtils.EntityManagerUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.interfaces.IGenericDAO;
import javax.persistence.EntityTransaction;

public class GenericDAO<T> implements IGenericDAO<T> {
    @PersistenceContext
    protected final EntityManager em;
    protected final Class<T> persistentClass;
    protected final EntityTransaction transaction;
    
    public GenericDAO(Class<T> typeParameterClass) {
        this.persistentClass = typeParameterClass;
        this.em = EntityManagerUtils.createEntityManager();
        this.transaction = em.getTransaction();
    }
    
    @Override
    public void insert(T entity) {
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(T entity) {
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(long id) {
        transaction.begin();
        em.remove(this.findById(id));
        transaction.commit();
    }

    @Override
    public List<T> listAll() {
        return em.createQuery(
            String.format("SELECT t FROM %s t", persistentClass.getSimpleName())
        ).getResultList();
    }
    
    @Override
    public T findById(long id) {
        return em.find(persistentClass, id);
    }
}
