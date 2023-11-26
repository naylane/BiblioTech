package dao;

import exceptions.LoanException;
import exceptions.UsersException;
import model.Loan;
import model.Reader;
import model.Report;

import java.io.*;
import java.util.HashMap;

public class FileControl {
    /**
     * Método que cria o diretório e arquivos binários caso os mesmos não sejam encontrados.
     */
    public static void generateData() throws LoanException {
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

        if (!(new File("data\\report.dat")).exists()){
            FileControl.saveReport(new Report());
        }
    }

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

    public static void saveReport(Report report) {
        try {
            FileOutputStream fs = new FileOutputStream("data\\report.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(report);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static HashMap<Long, Reader> loadReader() throws UsersException {
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
            throw new UsersException(e.getMessage()); }
        catch (ClassNotFoundException e) {
            throw new UsersException("Classe não encontrada."); }
    }

    public static HashMap<Long, Loan> loadLoan() throws LoanException {
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
            throw new LoanException(e.getMessage()); }
        catch (ClassNotFoundException e) {
            throw new LoanException("Classe não encontrada."); }
    }

    public static Report loadReport() throws Exception {
        try {
            FileInputStream fs = new FileInputStream("data\\report.dat");
            ObjectInputStream os = new ObjectInputStream(fs);
            Report report = (Report) os.readObject();
            os.close();
            return report;
        } catch (IOException e) {
            throw new Exception(e.getMessage()); }
        catch (ClassNotFoundException e) {
            throw new Exception("Classe não encontrada."); }
    }

}
