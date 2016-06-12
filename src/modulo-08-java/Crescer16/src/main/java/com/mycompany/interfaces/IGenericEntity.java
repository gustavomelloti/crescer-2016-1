
package com.mycompany.interfaces;

import java.util.List;

public interface IGenericEntity<T>  {
    void insert(T entity);

    void update(T entity);

    void delete(T entity);
    
    void exportarCSV();

    List<T> listAll();
    
    T findById(long id);

}
