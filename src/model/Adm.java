package model;

import dao.adm.AdmDAO;
import dao.DAO;
import dao.adm.AdmDAOImpl;
import dao.book.BookDaoImpl;
import dao.librarian.LibrarianDAO;
import dao.librarian.LibrarianDAOImpl;
import dao.reader.ReaderDAO;
import dao.reader.ReaderDAOImpl;
import dao.report.ReportDAOImpl;

import java.util.List;

/**
 * A classe Adm é uma subclasse da classe
 * Librarian. Portando, ela herda os atributos e
 * métodos da superclasse Librarian. Além disso,
 * contém um construtor para criar o objeto e
 * métodos getters e setters para pegar e alterar
 * os atributos privados. Contém também metódos que
 * são especificos para as funcionalidades de um adm,
 * como criar novos usuarios, operações para usuarios
 * e gerenciamento do acervo.
 *
 * @author Sara Souza e Nayalane Ribeiro
 */
public class Adm extends Librarian { //o adm é responsavel pela criação dos user
    ReaderDAOImpl readerDAO = new ReaderDAOImpl();
    LibrarianDAOImpl librarianDAO = new LibrarianDAOImpl();
    AdmDAOImpl admDAO = new AdmDAOImpl();
    BookDaoImpl bookDAO = new BookDaoImpl();
    ReportDAOImpl reportDAO = new ReportDAOImpl();

    /**
     * Construtor da classe Adm para criar um novo administrador.
     *
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     */
    public Adm(String name, String pin, String phone, Residence address) {
        super(name, pin, phone, address);
        this.setId(readerDAO.getNextId());
    }

    //CRIAÇÃO DE USERS

    /**
     * Cria um novo leitor no sistema.
     *
     * @param name    O nome do leitor.
     * @param pin     A senha do leitor.
     * @param phone   O número de telefone do leitor.
     * @param address O endereço do leitor.
     * @return O leitor recém-criado.
     */
    public Reader creatReader(String name, String pin, String phone, Residence address){
        long id = readerDAO.getNextId();
        Reader reader = new Reader(name, pin, phone, address);
        //adicionar o reader ao banco de dados - falta fazer o dao reader
        ReaderDAO readerDao = DAO.getReaderDAO();
        readerDao.create(reader); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return reader;}

    /**
     * Cria um novo bibliotecário no sistema.
     *
     * @param name    O nome do bibliotecário.
     * @param pin     A senha do bibliotecário.
     * @param phone   O número de telefone do bibliotecário.
     * @param address O endereço do bibliotecário.
     * @return O bibliotecário recém-criado.
     */
    public Librarian creatLibrariam(String name, String pin, String phone, Residence address){ //bibliotecario não tem id
        long id = librarianDAO.getNextId();
        Librarian librarian = new Librarian(name, pin, phone, address);
        //adicionar o reader ao banco de dados
        LibrarianDAO librarianDao = DAO.getLibrarianDAO();
        librarianDao.create(librarian); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return librarian;}

    /**
     * Cria um novo administrador no sistema.
     *
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     * @return O administrador recém-criado.
     */
    public Adm creatAdm(String name, String pin, String phone, Residence address){
        long id = admDAO.getNextId();
        Adm adm = new Adm(name, pin, phone, address);

        AdmDAO admDao = DAO.getAdmDAO();
        admDao.create(adm); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return adm;}

    //OPERAÇÕES DE USERS

    /**
     * Bloqueia um leitor no sistema.
     *
     * @param reader O leitor a ser bloqueado.
     */
    public void blockReader(Reader reader) {
        reader.blockReader(reader);}

    /**
     * Desbloqueia um leitor no sistema.
     *
     * @param reader O leitor a ser desbloqueado.
     */
    public void unlockReader(Reader reader) {
        reader.unlockReader(reader);}

    /**
     * Bloqueia um bibliotecário no sistema.
     *
     * @param librarian O bibliotecário a ser bloqueado.
     */
    public void blockLibrarian(Librarian librarian) {
        librarian.blockLibrarian(librarian);}

    /**
     * Desbloqueia um bibliotecário no sistema.
     *
     * @param librarian O bibliotecário a ser desbloqueado.
     */
    public void unlockLibrarian(Librarian librarian) {
        librarian.unlockLibrarian(librarian);}

    /**
     * Proucura um leitor no sistema.
     *
     * @param id O Id do leitor a ser pesquisado.
     * @return Leitor retornado.
     */
    public Reader readerSearch(long id) {
            return readerDAO.findById(id);}

    /**
     * Proucura um bibliotecario no sistema.
     *
     * @param id O Id do bibliotecario a ser pesquisado.
     * @return bibliotecario retornado.
     */
    public Librarian librarianSearch(long id) {
        return librarianDAO.findById(id);}

    /**
     * Retorna todos os leitores do sistema.
     *
     * @return Lista com todos leitores existentes.
     */
    public List<Reader> AllReader(){
        return readerDAO.findAll();
    }

    /**
     * Retorna todos bibliotecarios do sistema.
     *
     * @return Lista com todos bibliotecarios existentes.
     */
    public List<Librarian> AllLibrarian(){
        return librarianDAO.findAll();
    }

    /**
     * Deleta todos leitores no sistema.
     *
     */
    public void deleteAllReader() {
        readerDAO.deleteAll();}

    /**
     * Deleta todos bibliotecarios no sistema.
     *
     */
    public void deleteAllLibrarian() {
        librarianDAO.deleteAll();}

    /**
     * Deleta um leitor no sistema.
     *
     */
    public void deleteReader(Reader reader) {
        readerDAO.delete(reader);}

    /**
     * Deleta um bibliotecario no sistema.
     *
     */
    public void deleteLibrarian(Librarian librarian) {
        librarianDAO.delete(librarian);}

    /**
     * Atualiza um leitor no sistema.
     *
     */
    public void updateReader(Reader reader) {
        readerDAO.update(reader);}

    /**
     * Atualiza um bibliotecario no sistema.
     *
     */
    public void updateLibrarian(Librarian librarian) {
        librarianDAO.update(librarian);}

    //GERENCIAMENTO DO ACERVO - a adição de livros o adm herda do bibliotecario

    /**
     * Remove um livro do sistema.
     *
     * @param book O livro a ser removido.
     */
    public void removeBook(Book book){
        bookDAO.delete(book);}

    /**
     * Atualiza as informações de um livro no sistema.
     *
     * @param book O livro a ser atualizado.
     */
    public void updateBook(Book book){
        bookDAO.update(book);}

    /**
     * Obtém a quantidade total de livros no sistema.
     */
    public void quantityBooks(){
        bookDAO.QuantityBooks();}

    /**
     * Obtém todos os livros no sistema.
     */
    public void AllBook(){
        bookDAO.findAll();}

    /**
     * Delete todos os livros no sistema.
     */
    public void deleteAllBook(){
        bookDAO.deleteAll();}

    //GERAR RELATÓRIOS

    /**
     * Criar relatorio no sistema.
     */
    public void genareteReport(){
        Report report = new Report();
        reportDAO.save(report);
    }

    /**
     * Gerar os livros/o livro mais popular(es).
     * @return uma lista de livros.
     */
    public List<Book> genareteHighestPopular(){
        if(reportDAO.getReport() == null){
            genareteReport();
            return null;
        }else{
            Report report = reportDAO.getReport();
            List<Book> BookHighest = report.generateBookHighestPopular();
            reportDAO.save(report);
            return BookHighest; //retornando uma lista pois pode ter mais de um livro popular
        }
    }

    /**
     * Gerar os livros que estão emprestados.
     * @return uma lista de livros.
     */
    public List<Book> genareteBoorowedBooks(){
        if(reportDAO.getReport() == null){
            genareteReport();
            return null;
        }else{
            Report report = reportDAO.getReport();
            List<Book> BooksBorrowed = report.generatesBorrowedBooks();
            reportDAO.save(report);
            return BooksBorrowed; //retornando uma lista com os livros emprestados
        }
    }

    /**
     * Gerar os livros que estão atrasados.
     * @return uma lista de livros.
     */
    public List<Book> genareteLateBooks(){
        if(reportDAO.getReport() == null){
            genareteReport();
            return null;
        }else{
            Report report = reportDAO.getReport();
            List<Book> BooksLate = report.generatesLateBooks();
            reportDAO.save(report);
            return BooksLate; //retornando uma lista com os livros atrasados
    }}

    /**
     * Gerar os livros que estão reservados.
     * @return uma lista de livros.
     */
    public List<Book> genareteReservedBooks(){
        if(reportDAO.getReport() == null){
            genareteReport();
            return null;
        }else{
            Report report = reportDAO.getReport();
            List<Book> BooksReserved = report.generatesReservedBooks();
            reportDAO.save(report);
            return BooksReserved; //retornando uma lista com os livros reservados
    }}

    /**
     * Gerar o histórico de emprestimo de um usuario especifico.
     * @param reader leitor a ser retornado o historico de emprestimo.
     * @return uma lista de emprestimos.
     */
    public List<Loan> genareteUserLoan(Reader reader){
        if(reportDAO.getReport() == null){
            genareteReport();
            return null;
        }else{
            Report report = reportDAO.getReport();
            List<Loan> UserLoan = report.genareteUserLoan(reader);
            return UserLoan; //retornando uma lista com o historico de emprestimo de um leitor
    }}
}
