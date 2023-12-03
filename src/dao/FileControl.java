package dao;

import model.*;
import model.Reader;

import java.io.*;
import java.util.HashMap;

/**
 * Esta classe permite poder realizar o intermédio entre o arquivo binário que está salvo
 * na máquina, e as funcionalidades internas do sistema. Dessa forma, ele fica responsável por recuperar os dados
 * nos arquivos e salvar dados nesses arquivos. Assim, ele mantém os dados salvos após mesmo após fechar o programa,
 * ficando disponíveis para próxima abertura do programa.
 * @author Sara Souza e Naylane Ribeiro
 */
public class FileControl {
    /**
     * Método que cria o diretório e arquivos binários caso os mesmos não sejam encontrados.
     */
    public static void generateData() {
        if (!(new File("data").exists())) {
            File file = new File("data");
            file.mkdirs();
        }

        if (!(new File("data\\reader.dat")).exists()){
            FileControl.saveReader(new HashMap<Long, Reader>());
        }

        if (!(new File("data\\loan.dat")).exists()){
            FileControl.saveLoan(new HashMap<Long, Loan>());
        }

        if (!(new File("data\\adm.dat")).exists()){
            FileControl.saveAdm(new HashMap<Long, Adm>());

        }

        if (!(new File("data\\book.dat")).exists()) {
            FileControl.saveBook(new HashMap<String, Book>());
        }

        if (!(new File("data\\librarian.dat")).exists()) {
            FileControl.saveLibrarian(new HashMap<Long, Librarian>());
        }
    }

    /**
     * Método que salva o objeto adm no arquivo binário.
     */
    public static void saveAdm(HashMap<Long, Adm> map) {
        try {
            FileOutputStream fs = new FileOutputStream("data\\adm.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(map);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que salva o objeto book no arquivo binário.
     */
    public static void saveBook(HashMap<String, Book> map) {
        try {
            FileOutputStream fs = new FileOutputStream("data\\book.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(map);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que salva o objeto librarian no arquivo binário.
     */
    public static void saveLibrarian (HashMap<Long, Librarian> map) {
        try {
            FileOutputStream fs = new FileOutputStream("data\\librarian.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(map);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que salva o reader no arquivo binário.
     */
    public static void saveReader(HashMap<Long, Reader> map) {
        try {
            FileOutputStream fs = new FileOutputStream("data\\reader.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(map);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que salva o objeto loan no arquivo binário.
     */
    public static void saveLoan(HashMap<Long, Loan> map) {
        try {
            FileOutputStream fs = new FileOutputStream("data\\loan.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(map);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que recupera os dados do AdmDAO do arquivo binário.
     */
    public static HashMap<Long, Adm> loadAdm() throws Exception {
        try {
            FileInputStream fs = new FileInputStream("data\\adm.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            HashMap<Long, Adm> map = (HashMap<Long, Adm>) os.readObject();
            os.close();
            if (map.isEmpty()) {
                return new HashMap<Long, Adm>();
            }
            return map;
        } catch (IOException e) {
            throw new IOException(e.getMessage()); }
    }

    /**
     * Método que recupera os dados do BookDAO do arquivo binário.
     */
    public static HashMap<String, Book> loadBook() throws Exception {
        try {
            FileInputStream fs = new FileInputStream("data\\book.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            HashMap<String, Book> map = (HashMap<String, Book>) os.readObject();
            os.close();
            if (map.isEmpty()) {
                return new HashMap<String, Book>();
            }
            return map;
        } catch (IOException e) {
            throw new IOException(e.getMessage()); }
    }

    /**
     * Método que recupera os dados do LibrarianDAO do arquivo binário.
     */
    public static HashMap<Long, Librarian> loadLibrarian() throws Exception {
        try {
            FileInputStream fs = new FileInputStream("data\\librarian.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            HashMap<Long, Librarian> map = (HashMap<Long, Librarian>) os.readObject();
            os.close();
            if (map.isEmpty()) {
                return new HashMap<Long, Librarian>();
            }
            return map;
        } catch (IOException e) {
            throw new IOException(e.getMessage()); }
    }

    /**
     * Método que recupera os dados do ReaderDAO do arquivo binário.
     */
    public static HashMap<Long, Reader> loadReader() throws Exception {
        try {
            FileInputStream fs = new FileInputStream("data\\reader.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            HashMap<Long, Reader> map = (HashMap<Long, Reader>) os.readObject();
            os.close();
            if (map.isEmpty()) {
                return new HashMap<Long, Reader>();
            }
            return map;
        } catch (IOException e) {
            throw new IOException(e.getMessage()); }
    }

    /**
     * Método que recupera os dados do LoanDAO do arquivo binário.
     */
    public static HashMap<Long, Loan> loadLoan() throws Exception {
        try {
            FileInputStream fs = new FileInputStream("data\\loan.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            HashMap<Long, Loan> map = (HashMap<Long, Loan>) os.readObject();
            os.close();
            if (map.isEmpty()) {
                return new HashMap<Long, Loan>();
            }
            return map;
        } catch (IOException e) {
            throw new IOException(e.getMessage()); }
    }
}
