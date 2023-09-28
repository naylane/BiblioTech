package test;

//import dao.DAO;
//import model.*;
//import org.junit.*;

//import static org.junit.Assert.*;

public class BookTest {
    /*
    @Test
    public void registerBook() {
        // CRIANDO BIBLIOTECARIO
        Residence address = new Residence("Bahia", "Feira de Santana", "Feira VI", "A", 14,44000000);
        Librarian librarian = new Librarian(1, "Mônica", "123", "75982854278", address);

        // CRIANDO LIVRO
        BookLocation location = new BookLocation("1", "4", "12");

        Book book = new Book(9788595081512L,"O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                      "HarperCollins", 2018, "Romance", location, 2);

        librarian.registerBook(9788595081512L,"O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 2);

        assertSame(4, DAO.getBookDAO().findById(9788595081512L).getQuantityAvailable());
    }

    @Test
    public void testAddBook() {
        BookLocation location = new BookLocation("1", "4", "12");
        Book book = new Book(9788595081512L,"O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 1);
        DAO.getBookDAO().creat(book);

        assertFalse(DAO.getBookDAO().findAll().isEmpty()); // verifica se a lista de livros está vazia
    }

    @Test
    public void testFindingBookById() {
        BookLocation location = new BookLocation("1", "4", "12");
        Book book = new Book(9788595081512L,"O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 1);
        DAO.getBookDAO().creat(book);

        Book expected = DAO.getBookDAO().findById(9788595081512L);

        assertSame(expected, book); // verifica se o livro adicionando é o mesmo que foi encontrado pelo id
    }

    @Test
    public void findByTitle(){
        BookLocation location = new BookLocation("1", "4", "12");
        Book book = new Book(9788595081512L,"O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 4);
        DAO.getBookDAO().creat(book);

        // verifica se o livro adicionando é o mesmo que foi encontrado pelo título
        for (Book books : DAO.getBookDAO().findByTitle("O Pequeno Príncipe")) {
            assertEquals(books.getTitle(), book.getTitle());
        }
    }

    @Test
    public void findByAuthor(){

    }

    @Test
    public void findByCategory(){

    }


     */
}
