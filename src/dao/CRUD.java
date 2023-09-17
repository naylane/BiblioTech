package dao;

import java.util.List;

public interface CRUD<T> {
    /**
     * Cria novo objeto
     *
     * @param obj
     * @return
     */
    public T criar(T obj);

    public List<T> encontrarTodos();

    public T encontrarPorId(int id);

    public T atualizar(T obj);

    public void apagar(T obj);
}
