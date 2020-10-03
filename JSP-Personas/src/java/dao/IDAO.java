/*
 */
package dao;

import java.util.List;

/**
 *
 * @author Luis Angel
 */
public interface IDAO<T, V> {
    
    public T insert(T entidad);
    
    public T update(T entidad);
    
    public boolean delete(V id);
    
    public T find(V id);
    
    public List<T> findAll();
}
