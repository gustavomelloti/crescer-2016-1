
package com.mycompany.interfaces;

import java.util.List;

public interface IGenericDAO<T> {
    void insert(T entity);

    void update(T entity);

    void delete(long id);

    List<T> listAll();
    
    T findById(long id);
}
