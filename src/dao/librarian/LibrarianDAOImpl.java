package dao.librarian;

import dao.FileControl;
import exceptions.UsersException;
import model.Librarian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarianDAOImpl implements LibrarianDAO {
    private HashMap<Long, Librarian> librarianMap;
    private long nextId;

    public LibrarianDAOImpl() throws UsersException {
        this.librarianMap = FileControl.loadLibrarian ();
        this.nextId = librarianMap.size();
    }

    public long getNextId() {
        /**
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }

    @Override
    public Librarian create(Librarian lib) {
        lib.setId(getNextId());
        librarianMap.put(lib.getId(), lib);
        FileControl.saveLibrarian(this.librarianMap);
        return lib;
    }

    @Override
    public List<Librarian> findAll() {
        return new ArrayList<>(librarianMap.values());
    }

    @Override
    public Librarian findById(long id) {
        return librarianMap.get(id);
    }

    @Override
    public Librarian update(Librarian obj) {
        librarianMap.put(obj.getId(), obj);
        FileControl.saveLibrarian(this.librarianMap);
        return null;
    }

    @Override
    public void delete(Librarian obj) {
        long id = obj.getId();
        librarianMap.remove(id);
        FileControl.saveLibrarian(this.librarianMap);
    }

    @Override
    public void deleteAll() {
        librarianMap.clear();
        FileControl.saveLibrarian(this.librarianMap);
    }

    public Map<Long, Librarian> getLibrarianMap(){
        return librarianMap;}
}
