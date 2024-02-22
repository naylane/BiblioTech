package org.example.model;

import org.example.dao.DAO;
import org.example.exceptions.UsersException;

import java.io.Serializable;
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
public class Adm extends Librarian implements Serializable {
    /**
     * Construtor da classe Adm para criar um novo administrador.
     *
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     */
    public Adm(String name, String pin, String phone, Residence address, String position) throws Exception {
        super(name, pin, phone, address, position);
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
    public Reader creatReader(String name, String pin, String phone, Residence address, String position) throws Exception {
        Reader reader = new Reader(name, pin, phone, address, position);
        DAO.getReaderDAO().create(reader);
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
    public Librarian creatLibrariam(String name, String pin, String phone, Residence address, String position) throws Exception {
        Librarian librarian = new Librarian(name, pin, phone, address, position);
        DAO.getLibrarianDAO().create(librarian);
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
    public Adm creatAdm(String name, String pin, String phone, Residence address, String position) throws Exception {
        Adm adm = new Adm(name, pin, phone, address, position);
        DAO.getAdmDAO().create(adm); // criou o book no banco de dados e armazenou no map tendo o seu id como chave
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
    public Reader readerSearch(long id) throws Exception {
        return DAO.getReaderDAO().findById(id);}

    /**
     * Proucura um bibliotecario no sistema.
     *
     * @param id O Id do bibliotecario a ser pesquisado.
     * @return bibliotecario retornado.
     */
    public Librarian librarianSearch(long id) throws Exception {
        return DAO.getLibrarianDAO().findById(id);}

    /**
     * Proucura um adm no sistema.
     *
     * @param id O Id do bibladmiotecario a ser pesquisado.
     * @return adm retornado.
     */
    public Adm admSearch(long id) throws Exception {
        return DAO.getAdmDAO().findById(id);}

    /**
     * Retorna todos os leitores do sistema.
     *
     * @return Lista com todos leitores existentes.
     */
    public List<Reader> AllReader() throws Exception {
        return DAO.getReaderDAO().findAll();
    }

    /**
     * Retorna todos bibliotecarios do sistema.
     *
     * @return Lista com todos bibliotecarios existentes.
     */
    public List<Librarian> AllLibrarian() throws Exception {
        return DAO.getLibrarianDAO().findAll();
    }

    /**
     * Deleta todos leitores no sistema.
     *
     */
    public void deleteAllReader() throws Exception {
        DAO.getReaderDAO().deleteAll();}

    /**
     * Deleta todos bibliotecarios no sistema.
     *
     */
    public void deleteAllLibrarian() throws Exception {
        DAO.getLibrarianDAO().deleteAll();}

    /**
     * Deleta um leitor no sistema.
     *
     */
    public void deleteReader(Reader reader) throws Exception {
        DAO.getReaderDAO().delete(reader);}

    /**
     * Deleta um bibliotecario no sistema.
     *
     */
    public void deleteLibrarian(Librarian librarian) throws Exception {
        DAO.getLibrarianDAO().delete(librarian);}

    /**
     * Atualiza um leitor no sistema.
     *
     */
    public void updateReader(Reader reader) throws Exception {
        DAO.getReaderDAO().update(reader);}

    /**
     * Atualiza um bibliotecario no sistema.
     *
     */
    public void updateLibrarian(Librarian librarian) throws Exception {
        DAO.getLibrarianDAO().update(librarian);}

    /**
     * Atualiza um Adm no sistema.
     *
     */
    public void updateAdm(Adm adm) throws Exception {
        DAO.getAdmDAO().update(adm);}

    //GERENCIAMENTO DO ACERVO - a adição de livros o adm herda do bibliotecario

    /**
     * Remove um livro do sistema.
     *
     * @param book O livro a ser removido.
     */
    public void removeBook(Book book) throws Exception {
        DAO.getBookDAO().delete(book);}

    /**
     * Atualiza as informações de um livro no sistema.
     *
     * @param book O livro a ser atualizado.
     */
    public void updateBook(Book book) throws Exception {
        DAO.getBookDAO().update(book);}

    /**
     * Obtém a quantidade total de livros no sistema.
     */
    public void quantityBooks() throws Exception {
        DAO.getBookDAO().quantityBooks();
    }

    /**
     * Obtém todos os livros no sistema.
     */
    public void AllBook() throws Exception {
        DAO.getBookDAO().findAll();}

    /**
     * Delete todos os livros no sistema.
     */
    public void deleteAllBook() throws Exception {
        DAO.getBookDAO().deleteAll();}

    // RELATÓRIOS

    /**
     * Gerar os livros/o livro mais popular(es).
     * @return uma lista de livros.
     */
    public List<Book> genareteHighestPopular(Report report) {
        return report.generateBookHighestPopular();
    }

    /**
     * Gera o relatório contendo a quantidade de livros emprestados.
     * @return Quantidade de livros emprestados.
     */
    public long generateBorrowedBooks(Report report) {
        return report.generatesBorrowedBooks();
    }

    /**
     * Gera o relatório contendo a quantidade de livros que estão atrasados.
     * @return Quantidade de livros atrasados
     */
    public long generateLateBooks(Report report) {
        return report.generatesLateBooks();
    }

    /**
     * Gera o relatório contendo a quantidade de livros que estão reservados.
     * @return Quantidade de livros reservados.
     */
    public long generateReservedBooks(Report report){
        return report.generatesReservedBooks();
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
