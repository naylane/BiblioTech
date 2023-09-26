package dao.librarian;

import model.Librarian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarianDAOImpl implements LibrarianDAO {
    private final Map<Integer, Librarian> librarianMap = new HashMap<>();

    /**
     * Método que adiciona um objeto ao seu referente HashMap.
     * @param librarian bibliotecário
     * @return bibliotecário
     */
    @Override
    public Librarian creat(Librarian librarian) {
        int id = librarian.getId();
        librarianMap.put(id, librarian);
        return librarian;
    }

    /**
     * @return ArrayList
     */
    @Override
    public List<Librarian> findAll() {
        return new ArrayList<>(librarianMap.values());
    }

    /**
     * @param id identificador do biliotecário
     * @return bibliotecário
     */
    @Override
    public Librarian findById(int id) {
        return librarianMap.get(id);
    }

    /**
     * @param librarian bibliotecário
     * @return bibliotecário
     */
    @Override
    public Librarian update(Librarian librarian) {
        librarianMap.put(librarian.getId(), librarian);
        return librarian;
    }

    /**
     * @param librarian bibliotecário
     */
    @Override
    public void delete(Librarian librarian) {
        int id = librarian.getId();
        librarianMap.remove(id);
    }

    @Override
    public void deleteAll() {
        librarianMap.clear();
    }
}
