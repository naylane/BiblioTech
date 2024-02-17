package org.example.util;

import org.example.model.Librarian;

public class LibrarianHolder {
    private static LibrarianHolder instance;
    private Librarian librarian;

    private LibrarianHolder(Librarian librarian) {
        this.librarian = librarian;
    }

    public static LibrarianHolder getInstance() {
        if (instance == null) {
            instance = new LibrarianHolder(null);
        }
        return instance;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Librarian getLibrarian() {
        return this.librarian;
    }

}