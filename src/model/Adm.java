package model;

import dao.Adm.AdmDAO;
import dao.Book.BookDAO;
import dao.DAO;
import dao.Librarian.LibrarianDAO;
import dao.Reader.ReaderDAO;

import java.time.LocalDate;

public class Adm extends Librarian { //o adm é responsavel pela criação dos user
    private int idReader = 0; //cada tipo de usuario tem um id diferente
    public int idLibrarian = 0;
    public int idAdm = 0;
    public int generateId(int id){ //gerar automaticamente o id do emprestimo
        return id +=1;}
    public LocalDate dateToday(){
        return LocalDate.now();} //pega a data de hoje
    public Adm(String name, int id, String pin, int age, int phone, LocalDate registration_date, Residence address) {
        super(name, id, pin, age, phone, registration_date, address);
    }
    public Reader CreatReader(String name, String pin, int age, int phone, Residence address){
        int id = generateId(idReader);
        LocalDate date = dateToday();
        Reader reader = new Reader(name, id, pin, age, phone, date, address);
        //adicionar o reader ao banco de dados - falta fazer o dao reader
        ReaderDAO readerDao = DAO.getReaderDAO();
        readerDao.creat(reader); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return reader;
    }
    public Librarian CreatLibrariam(String name, String pin, int age, int phone, Residence address){ //bibliotecario não tem id
        LocalDate date = dateToday();
        int id = generateId(idLibrarian);
        Librarian librarian = new Librarian(name, id, pin, age, phone, date, address);
        //adicionar o reader ao banco de dados
        LibrarianDAO librarianDao = DAO.getLibrarianDAO();
        librarianDao.creat(librarian); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return librarian;
    }
    public Adm CreatAdm(String name, String pin, int age, int phone, Residence address){
        LocalDate date = dateToday();
        int id = generateId(idAdm);
        Adm adm = new Adm(name, id, pin, age, phone, date, address);
        //adicionar o reader ao banco de dados
        AdmDAO admDao = DAO.getAdmDAO();
        admDao.creat(adm); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return adm;
    }
}
