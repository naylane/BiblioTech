package model;

import dao.adm.AdmDAO;
import dao.DAO;
import dao.book.BookDAO;
import dao.librarian.LibrarianDAO;
import dao.reader.ReaderDAO;
import dao.report.ReportDAO;
import exceptions.LoanException;

import java.io.IOException;
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
 * @author Sara Souza e Naylane Ribeiro
 */
public class Adm extends Librarian {
    ReaderDAO readerDAO = DAO.getReaderDAO();
    LibrarianDAO librarianDAO = DAO.getLibrarianDAO();
    BookDAO bookDAO = DAO.getBookDAO();
    ReportDAO reportDAO = DAO.getReportDAO();

    /**
     * Construtor da classe Adm para criar um novo administrador.
     *
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     */
    public Adm(String name, String pin, String phone, Residence address) throws Exception {
        super(name, pin, phone, address);
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
    public Reader creatReader(String name, String pin, String phone, Residence address) throws IOException {
        Reader reader = new Reader(name, pin, phone, address);
        readerDAO.create(reader);
        return reader;
    }

    /**
     * Cria um novo bibliotecário no sistema.
     *
     * @param name    O nome do bibliotecário.
     * @param pin     A senha do bibliotecário.
     * @param phone   O número de telefone do bibliotecário.
     * @param address O endereço do bibliotecário.
     * @return O bibliotecário recém-criado.
     */
    public Librarian creatLibrariam(String name, String pin, String phone, Residence address) throws Exception {
        Librarian librarian = new Librarian(name, pin, phone, address);
        librarianDAO.create(librarian);
        return librarian;
    }

    /**
     * Cria um novo administrador no sistema.
     *
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     * @return O administrador recém-criado.
     */
    public Adm creatAdm(String name, String pin, String phone, Residence address) throws Exception {
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
        bookDAO.quantityBooks();
    }

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

    // RELATÓRIOS

    /**
     * Criar relatorio no sistema.
     * @return Relatório
     */
    public Report genareteReport() throws LoanException {
        return reportDAO.getReport();
    }

    /**
     * Gerar os livros/o livro mais popular(es).
     * @return uma lista de livros.
     */
    public List<Book> genareteHighestPopular(Report report) {
        List<Book> highestPopular = report.generateBookHighestPopular();
        reportDAO.save(report);
        return highestPopular;
    }

    /**
     * Gerar os livros que estão emprestados.
     * @return uma lista de livros.
     */
    public List<Book> genareteBoorowedBooks(Report report) {
        List<Book> borrowedBooks = report.generatesBorrowedBooks();
        reportDAO.save(report);
        return borrowedBooks;
    }

    /**
     * Gerar os livros que estão atrasados.
     * @return uma lista de livros.
     */
    public List<Book> genareteLateBooks(Report report) {
        List<Book> booksLate = report.generatesLateBooks();
        reportDAO.save(report);
        return booksLate;
    }

    /**
     * Gerar os livros que estão reservados.
     * @return uma lista de livros.
     */
    public List<Book> genareteReservedBooks(Report report){
        List<Book> booksReserved = report.generatesReservedBooks();
        reportDAO.save(report);
        return booksReserved;
    }

    /**
     * Gerar o histórico de emprestimo de um usuario especifico.
     * @param reader leitor a ser retornado o historico de emprestimo.
     * @return uma lista de emprestimos.
     */
    public List<Loan> genareteUserLoan(Reader reader, Report report){
        return report.genareteUserLoan(reader);
    }

}
