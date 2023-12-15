package br.com.restful.control.dao.generic;

import java.util.List;

public interface GenericDAO<T, K> {

    void post(T entity);

    void update(T entity);

    T getOne(K key);

    void delete(K key) throws Exception;

    List<T> getAll();

    void commit() throws Exception;

}
