package org.senai.devinhouse.m1s09.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(int id);
    int add(T t);
    T update(int id, T t);
    T delete(int id);

}
