/**
 * A classe Reader é uma subclasse da classe
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

package model;

import dao.adm.AdmDAO;
import dao.DAO;
import dao.adm.AdmDAOImpl;
import dao.book.BookDaoImpl;
import dao.librarian.LibrarianDAO;
import dao.librarian.LibrarianDAOImpl;
import dao.reader.ReaderDAO;
import dao.reader.ReaderDAOImpl;
import exceptions.UsersException;

public class Adm extends Librarian { //o adm é responsavel pela criação dos user
    ReaderDAOImpl readerDAO = new ReaderDAOImpl();
    LibrarianDAOImpl librarianDAO = new LibrarianDAOImpl();
    AdmDAOImpl admDAO = new AdmDAOImpl();
    BookDaoImpl books = new BookDaoImpl();

    /**
     * Construtor da classe Adm para criar um novo administrador.
     *
     * @param id      O ID do administrador.
     * @param name    O nome do administrador.
     * @param pin     A senha do administrador.
     * @param phone   O número de telefone do administrador.
     * @param address O endereço do administrador.
     */
    public Adm(long id, String name, String pin, String phone, Residence address) {
        super(id, name, pin, phone, address);
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
        Reader reader = new Reader(id, name, pin, phone, address);
        //adicionar o reader ao banco de dados - falta fazer o dao reader
        ReaderDAO readerDao = DAO.getReaderDAO();
        readerDao.creat(reader); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
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
        Librarian librarian = new Librarian(id, name, pin, phone, address);
        //adicionar o reader ao banco de dados
        LibrarianDAO librarianDao = DAO.getLibrarianDAO();
        librarianDao.creat(librarian); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
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
        Adm adm = new Adm(id, name, pin, phone, address);

        AdmDAO admDao = DAO.getAdmDAO();
        admDao.creat(adm); //criou o book no banco de dados e armazenou no map tendo o seu id como chave
        return adm;}

    //OPERAÇÕES DE USERS

    /**
     * Bloqueia um leitor no sistema.
     *
     * @param reader O leitor a ser bloqueado.
     * @throws UsersException se ocorrer um erro durante o bloqueio do leitor.
     */
    public void blockReader(Reader reader) throws UsersException{
        if(reader.getBlock()){throw new UsersException(UsersException.AlreadyUserBlock);}
        else{reader.blockReader(reader);}}

    /**
     * Desbloqueia um leitor no sistema.
     *
     * @param reader O leitor a ser desbloqueado.
     * @throws UsersException se ocorrer um erro durante o desbloqueio do leitor.
     */
    public void unlockReader(Reader reader) throws UsersException {
        if(!reader.getBlock()){throw new UsersException(UsersException.AlreadyUserUnlock);}
        else{reader.unlockReader(reader);}}

    /**
     * Bloqueia um bibliotecário no sistema.
     *
     * @param librarian O bibliotecário a ser bloqueado.
     * @throws UsersException se ocorrer um erro durante o bloqueio do bibliotecário.
     */
    public void blockLibrarian(Librarian librarian) throws UsersException {
        if(librarian.getBlock()){throw new UsersException(UsersException.AlreadyUserBlock);}
        else{librarian.blockLibrarian(librarian);}}

    /**
     * Desbloqueia um bibliotecário no sistema.
     *
     * @param librarian O bibliotecário a ser desbloqueado.
     * @throws UsersException se ocorrer um erro durante o desbloqueio do bibliotecário.
     */
    public void unlockLibrarian(Librarian librarian) throws UsersException{
        if(!librarian.getBlock()){throw new UsersException(UsersException.AlreadyUserUnlock);}
        else{librarian.unlockLibrarian(librarian);}}

    //GERENCIAMENTO DO ACERVO - a adição de livros o adm herda do bibliotecario

    /**
     * Remove um livro do sistema.
     *
     * @param book O livro a ser removido.
     */
    public void removeBook(Book book){books.delete(book);}

    /**
     * Atualiza as informações de um livro no sistema.
     *
     * @param book O livro a ser atualizado.
     */
    public void updateBook(Book book){books.update(book);}

    /**
     * Obtém a quantidade total de livros no sistema.
     */
    public void quantityBooks(){books.QuantityBooks();}
}
