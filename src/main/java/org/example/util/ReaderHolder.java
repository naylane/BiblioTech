package org.example.util;

import org.example.model.Reader;

public class ReaderHolder {
    private static ReaderHolder instance;
    private Reader reader;

    private ReaderHolder(Reader reader) {
        this.reader = reader;
    }

    public static ReaderHolder getInstance() {
        if (instance == null) {
            instance = new ReaderHolder(null);
        }
        return instance;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Reader getReader() {
        return this.reader;
    }
}
