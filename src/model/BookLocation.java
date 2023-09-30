package model;

/**
 * Esta classe contém atributos para armazenar o local de
 * um livro. Portanto ela contém atributos como
 * prateleira, sessão e corredor. Além disso, ela contém
 * um construtor para criar o objeto e métodos getters
 * e setters para pegar e alterar os atributos privados.
 *
 * @author Sara Souza e Naylane Ribeiro
 */
public class BookLocation {
    private String shelf;
    private String hall;
    private String section;

    /**
     * Construtor da classe BookLocation.
     *
     * @param shelf    O número da prateleira onde o livro está localizado.
     * @param hall     O corredor onde o livro está localizado.
     * @param section  A seção específica onde o livro está localizado.
     */
    public BookLocation(String shelf, String hall, String section) {
        this.shelf = shelf;
        this.hall = hall;
        this.section = section;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
