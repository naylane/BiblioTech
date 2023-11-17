package dao;

import java.io.IOException;
import java.util.List;

//aq é onde fica as assinaturas dos metodos para serem usadas nas interfaces DAO
public interface CRUD<T> {

    public T create(T obj) throws IOException;

    public List<T> findAll();

    public T findById(long id);
    public T update(T obj);

    public void delete(T obj);

    public void deleteAll();
}