package model;

import dao.adm.AdmDAO;
import dao.DAO;
import dao.librarian.LibrarianDAO;
import dao.Reader.ReaderDAO;

import java.time.LocalDate;

public class Adm extends Librarian { //o adm é responsavel pela criação dos user
    private long idReader = 0; // cada tipo de usuario tem um id diferente
    public long idLibrarian = 0;
    public long idAdm = 0;

    public Adm(long id, String name, String pin, int phone, Residence address) {
        super(id, name, pin, phone, address);
    }

    public long generateId(long id){ // gera automaticamente o id do emprestimo
        return id += 1;
    }

    public LocalDate dateToday(){
        return LocalDate.now();
    } //pega a data de hoje

    public Reader creatReader(String name, String pin, int age, int phone, Residence address){
        long id = generateId(idReader);
        LocalDate date = dateToday();
        Reader reader = new Reader(id, name, pin, phone, address);
        //adicionar o reader ao banco de dados - falta fazer o dao reader
        ReaderDAO readerDao = DAO.getReaderDAO();
        readerDao.creat(reader); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return reader;
    }

    public Librarian creatLibrariam(String name, String pin, int phone, Residence address){ //bibliotecario não tem id
        LocalDate date = dateToday();
        long id = generateId(idLibrarian);
        Librarian librarian = new Librarian(id, name, pin, phone, address);
        //adicionar o reader ao banco de dados
        LibrarianDAO librarianDao = DAO.getLibrarianDAO();
        librarianDao.creat(librarian); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return librarian;
    }

    public Adm creatAdm(String name, String pin, int phone, Residence address){
        LocalDate date = dateToday();
        long id = generateId(idAdm);
        Adm adm = new Adm(id, name, pin, phone, address);
        //adicionar o reader ao banco de dados
        AdmDAO admDao = DAO.getAdmDAO();
        admDao.creat(adm); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return adm;
    }
}
