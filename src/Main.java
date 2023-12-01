import dao.DAO;
import dao.FileControl;
import dao.adm.AdmDAO;
import exceptions.LoanException;
import exceptions.UsersException;
import model.*;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        FileControl.generateData();

        System.out.println("Printando ADM");
        for (Map.Entry<Long, Adm> entry : DAO.getAdmDAO().getAdmMap().entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Reader");
        for (Map.Entry<Long, Reader> entry : DAO.getReaderDAO().getReaderMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Librarian");
        for (Map.Entry<Long, Librarian> entry : DAO.getLibrarianDAO().getLibrarianMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Book");
        for (Map.Entry<String, Book> entry : DAO.getBookDAO().getBookMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Loan");
        for (Map.Entry<Long, Loan> entry : DAO.getLoanDAO().getLoanMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        /*

        //adicionando dados nor arquivos
        Residence address = new Residence("state", "city", "neighbourhood", "street", 0, "cep");
        Residence address1 = new Residence("state1", "city", "neighbourhood", "street", 44, "cep1");
        Adm adm = new Adm("name adm", "pin", "phone", address);
        DAO.getAdmDAO().create(adm);
        Reader reader1 = adm.creatReader("Sara", "1405", "xx xxxxx-xxxx", address);
        adm.creatReader("Lara", "0202", "xx xxxxx-xxxx", address1);
        adm.creatReader("Nay", "45", "xx xxxxx-xxxx", address);
        adm.creatReader("Laiza", "2525", "xx xxxxx-xxxx", address1);
        adm.creatReader("Brenda", "2525", "xx xxxxx-xxxx", address1);
        adm.creatLibrariam("nay","123","xxxxxxx", address);
        adm.creatLibrariam("nay","123","xxxxxxx", address);
        BookLocation location = new BookLocation("1", "4", "12");
        adm.registerBook("9788595081512","O Pequeno Príncipe", "Antoine de Saint-Exupéry",
                "HarperCollins", 2018, "Romance", location, 1);
        Book book1 = DAO.getBookDAO().findByIsbn("9788595081512");
        adm.registerLoan(reader1, book1);

        //printando
        System.out.println("Printando ADM");
        for (Map.Entry<Long, Adm> entry : DAO.getAdmDAO().getAdmMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Reader");
        for (Map.Entry<Long, Reader> entry : DAO.getReaderDAO().getReaderMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Librarian");
        for (Map.Entry<Long, Librarian> entry : DAO.getLibrarianDAO().getLibrarianMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Book");
        for (Map.Entry<String, Book> entry : DAO.getBookDAO().getBookMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Printando Loan");
        for (Map.Entry<Long, Loan> entry : DAO.getLoanDAO().getLoanMap().entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        } */
    }
}
