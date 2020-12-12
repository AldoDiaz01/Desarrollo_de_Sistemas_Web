package com.uv.empresaurios.dao;
import java.util.List;

public interface IDao<T, V> {
    
    public void insert(T entity);
    
    public void update(T entity);
    
    public boolean delete(V id);
    
    public T find(V id);
    
    public List<T> findAll();
    
}
