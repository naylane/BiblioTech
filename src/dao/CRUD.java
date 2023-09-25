package dao;

import java.util.List;

//aq é onde fica as assinaturas dos metodos para serem usadas nas interfaces DAO
public interface CRUD<T> {

    public T creat(T obj);

    public List<T> findAll(); //retorna uma lista de obj

    public T findById(int id); //retorna um objeto

    public T update(T obj);

    public void delete(T obj);

    public void deleteAll();
}