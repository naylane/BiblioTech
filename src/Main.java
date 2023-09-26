import dao.DAO;
import dao.Book.BookDAO;
import model.Book;
import model.BookLocation;

import java.util.List;

//classe main so pra testar
public class Main {
    public static void main(String[] args){
        //criando livro e adicionando as informações na classe
        Book book = new Book(123456, "Título do Livro", "Autor do Livro",  //o bookdao é uma classe que ira mexer com o banco de dados
                "Editora XYZ", 2023, "Ficção",
                new BookLocation("1", "2", "XXX"), 3);

        //Usando o DAO para adicionar o livro ao banco de dados
        BookDAO bookDao = DAO.getBookDAO();
        bookDao.creat(book); //criou o book no banco de dados e armazenou no map tendo o seu isbn como id
        //exibindo as informações do livro
        System.out.println(book.toString());
        //ler todos livros
        List<Book> allbooks = bookDao.findAll();
        // Iterando e imprimindo os elementos da lista
        for (Book item : allbooks) {
            System.out.println(item);}
    }}