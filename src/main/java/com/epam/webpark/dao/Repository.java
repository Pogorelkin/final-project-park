package com.epam.webpark.dao;

import java.io.Serializable;
import java.util.List;

 public interface Repository<T extends Serializable> extends BasicDAO {
    List<T> displayAll();

    void add(T obj);

    void deleteById(Long idObj);

    void update(Long idObj, T obj);

    T findById(Long idObj);

}
