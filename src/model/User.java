package model;

import dao.DAO;
import exceptions.BookException;

import java.util.List;

import static dao.DAO.bookDAO;

/**
 * Esta classe é uma superclasse que implementa o
 * comportamento de um usuario. Portanto ela contém
 * os atributos de um usuario como nome, id, senha,
 * endereço e telefone. Além disso, ela contém um
 * construtor para criar o objeto e métodos getters e
 * setters para pegar e alterar os atributos privados.
 * Contém também metódos que são utlizados para
 * fazer pesquisas de livros.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
public class User {
    private long id;
    private String name;
    private String pin;
    private String phone;
    private Residence address;

    /**
     * Construtor da classe User.
     *
     * @param name    O nome do usuário.
     * @param pin     A senha do usuário.
     * @param phone   O telefone do usuário.
     * @param address O endereço do usuário.
     */
    public User(String name, String pin, String phone, Residence address){
        this.name = name;
        this.pin = pin;
        this.phone = phone;
        this.address = address;}

    // Métodos Get
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public String getPhone() {
        return phone;
    }

    public Residence getAddress() {
        return address;
    }

    // Métodos Set
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Residence address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "[User]: " + id + "\n -Informations-\n" + "name: " + name  + "phone: " + phone;
    }

    /**
     * Método que compara um objeto com outro para verificar se seus IDs são iguais.
     *
     * @param o O objeto a ser comparado.
     * @return true se os IDs forem iguais, false caso contrário.
     */
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    /**
     * Método para pesquisar livros por ISBN.
     *
     * @param isbn O ISBN do livro a ser pesquisado.
     * @return O livro encontrado com o ISBN especificado.
     * @throws BookException lança execeção caso o livro não seja encontrado.
     */
    public Book searchBookByIsbn(String isbn) throws BookException {
        if (DAO.getBookDAO().findById(isbn) == null) { throw new BookException(BookException.BookNotFound);
        } else { return DAO.getBookDAO().findById(isbn); }
    }

    /**
     * Método para pesquisar livros por título.
     *
     * @param title O título do livro a ser pesquisado.
     * @return Uma lista de livros encontrados com o título especificado.
     * @throws BookException lança execeção caso o livro não seja encontrado.
     */
    public List<Book> searchBookByTitle(String title) throws BookException{
        // Chama o método de pesquisa por título no DAO de livros
        if(bookDAO.findByTitle(title).isEmpty()){throw new BookException(BookException.BookNotFound);}
        else{return bookDAO.findByTitle(title);}}

    /**
     * Método para pesquisar livros por autor.
     *
     * @param author O autor do livro a ser pesquisado.
     * @return Uma lista de livros encontrados com o autor especificado.
     * @throws BookException lança execeção caso o livro não seja encontrado.
     */
    public List<Book> searchBooksByAuthor(String author) throws BookException{
        // Chama o método de pesquisa por autor no DAO de livros
        if(bookDAO.findByAuthor(author).isEmpty()){throw new BookException(BookException.BookNotFound);}
        else{return bookDAO.findByAuthor(author);
        }}

    /**
     * Método para pesquisar livros por categoria.
     *
     * @param category A categoria do livro a ser pesquisada.
     * @return Uma lista de livros encontrados na categoria especificada.
     * @throws BookException lanaça execeção caso o livro não seja encontrado.
     */
    public List<Book> searchBooksByCategory(String category) throws BookException{
        // Chama o método de pesquisa por categoria no DAO de livros
        if(bookDAO.findByCategory(category).isEmpty()){throw new BookException(BookException.BookNotFound);}
        else{return bookDAO.findByCategory(category);}}
}
