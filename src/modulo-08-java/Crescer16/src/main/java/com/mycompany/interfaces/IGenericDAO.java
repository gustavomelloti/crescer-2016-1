
package com.mycompany.interfaces;

import java.util.List;

public interface IGenericDAO<T> {
    void insert(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> listAll();
}
