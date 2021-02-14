package com.uisrael.bodegaControl.modelo.dao;

import java.util.List;

public interface GenericaDao <T> {
    public T create(T t);
    
    public T read (Object id);
    
    public T update (T t);
    
    public void delete(T t);
 
    public void beginTransaction();
    
    public void commit();

    public void rollback();
   
    public void closeTransaction();
    
    public void commitAndCloseTransaction();
    
    public void flush();

    public List<T> findAll();

}
