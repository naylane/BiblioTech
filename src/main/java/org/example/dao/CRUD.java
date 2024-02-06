package org.example.dao;

import java.io.IOException;
import java.util.List;

public interface CRUD<T> {
    // assinaturas dos metodos para serem usadas nas interfaces DAO

    public T create(T obj) throws IOException;

    public List<T> findAll();

    public T findById(long id);

    public T update(T obj);

    public void delete(T obj);

    public void deleteAll();
}