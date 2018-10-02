package com.epam.webpark.service;

import java.io.Serializable;
import java.util.List;

public interface BasicService<T extends Serializable> {
    List<T> getAll();

    void add(T obj);

    void deleteById(Long idObj);

    void update(Long idObj, T obj);

    T findById(Long idObj);
}
