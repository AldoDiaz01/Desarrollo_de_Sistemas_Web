package com.combi.personasapi.dao;

import java.util.List;

public interface IDao<T, V> {
    public T insert(T entidad);

    public T update(T entidad);

    public boolean delete(V id);

    public T find(V id);

    public List<T> findAll();
}
