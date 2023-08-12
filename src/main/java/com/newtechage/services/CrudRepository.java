package com.newtechage.services;


import java.util.Set;

public interface CrudRepository<T,S> {

    Set<T> findAll();

    T findById(S id);

    boolean save(T t);

    T update(T t);

    boolean delete(S s);

    boolean deleteById(S s);
}
