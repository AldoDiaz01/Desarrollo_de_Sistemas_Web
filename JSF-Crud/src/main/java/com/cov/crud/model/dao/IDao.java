package com.cov.crud.model.dao;

import java.util.List;

public interface IDao<T, V> {

    public void insert(T entity);

    public T select(V id);

    public List<T> selectById();

    public boolean delete(V id);

    public void update(T entity);
}
