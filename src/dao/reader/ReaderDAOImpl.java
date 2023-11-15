package dao.reader;
import model.Reader;
import model.Residence;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.FileNotFoundException;

public class ReaderDAOImpl implements ReaderDAO {
    private Map<Long, Reader> readerMap = new HashMap<>();
    private long nextId = 0;

    public long getNextId() {
        //Primeiro ele faz a verificação se existe elementos no arquivo, caso exista, ele proucura o maior ID
        long biggerId = 0;
        Path path = Paths.get("./data/reader.csv");
        try {
            long fileSize = Files.size(path); // Se o tamanho for maior que zero, o arquivo contém dados
            if (fileSize > 0) { //se for maior que 0, vai pegar o maior ID do arquivo
                try (Scanner scanner = new Scanner(new File("./data/reader.csv"))) { //caminho do arquivo
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine(); //le a linha
                        String[] parts = line.split(","); //divide em partes
                        if (parts.length >= 10) {
                            long id = Long.parseLong(parts[0].trim());
                            if (id > biggerId) { //para pegar o maior id do arquivo
                                biggerId = id;
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if(biggerId!=0){nextId = biggerId;
        return this.nextId+1;}
        else{return this.nextId++;}
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
    }

    public void saveData() {
        String csvFilePath = "./data/reader.csv"; // caminho do arquivo CSV
        try (FileWriter writter = new FileWriter(csvFilePath, true)) { // O segundo argumento true no construtor do FileWriter indica que você está abrindo o arquivo no modo de anexação

            for (Map.Entry<Long, Reader> entry : readerMap.entrySet()) {
                Reader reader = entry.getValue();

                String line = String.format("%d, %s, %s, %s, %s",
                        reader.getId(),
                        reader.getName(),
                        reader.getPin(),
                        reader.getPhone(),
                        reader.getAddress().toString()
                );
                writter.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recoverData() { //sempre antes de inciar o codigo é importante fazer a recuperação de dados
        Map<Long, Reader> mapRecovered = new HashMap<>(); //hashmap temporario
        try (Scanner scanner = new Scanner(new File("./data/reader.csv"))) { //caminho do arquivo
            while (scanner.hasNext()) {
                String line = scanner.nextLine(); //le a linha
                String[] parts = line.split(","); //divide em partes
                if (parts.length >= 10) {
                    long id = Long.parseLong(parts[0].trim());
                    String name = parts[1].trim();
                    String pin = parts[2].trim();
                    String phone = parts[3].trim();
                    String state = parts[4].trim();
                    String city = parts[5].trim();
                    String neighbourhood = parts[6].trim();
                    String street = parts[7].trim();
                    int number = Integer.parseInt(parts[8].trim());
                    String cep = parts[9].trim();
                    Residence address = new Residence(state, city, neighbourhood, street, number, cep);
                    Reader reader = new Reader(name, pin, phone, address); //cria novos objetos
                    mapRecovered.put(id, reader);
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        this.readerMap = mapRecovered;
    }

    @Override
    public Reader create(Reader obj) {
        recoverData();
        obj.setId(getNextId());
        readerMap.put(obj.getId(), obj);
        saveData();
        return obj;
    }

    @Override
    public List<Reader> findAll() {
        recoverData();
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public Reader findById(long id) {
        recoverData();
        return readerMap.get(id);
    }

    @Override
    public Reader update(Reader obj) {
        recoverData();
        readerMap.put(obj.getId(), obj);
        saveData();
        return obj;
    }

    @Override
    public void delete(Reader obj) {
        recoverData();
        readerMap.remove(obj.getId());
        saveData();
    }

    @Override
    public void deleteAll() {
        recoverData();
        readerMap.clear();
        saveData();
    }

    public Map<Long, Reader> getReaderMap() {
        recoverData();
        return readerMap;
    }
}