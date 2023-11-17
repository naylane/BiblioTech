package dao.reader;
import model.Reader;
import model.Residence;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderDAOImpl implements ReaderDAO {
    private Map<Long, Reader> readerMap = new HashMap<>();
    private long nextId = 0;

    public long getNextId(long id) {
        if(id == 0){this.nextId++;} //se não tiver nenhum elemento no arquivo
        else{this.nextId = id + 1;} //se tiver algum elemento no arquivo
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId;
    }

    public void saveData() {
        String csvFilePath = "./data/reader.csv"; // caminho do arquivo CSV
        try (FileWriter writter = new FileWriter(csvFilePath)) {
            for (Map.Entry<Long, Reader> entry : readerMap.entrySet()) {
                Reader reader = entry.getValue();
                long key = entry.getKey();
                Reader value = entry.getValue();

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

    public long recoverData() { //sempre antes de inciar o codigo é importante fazer a recuperação de dados
        String path = "./data/reader.csv";
        int lineCount = 0;
        long biggerId=0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.readLine() != null) { //serve para contar a quantidade de linhas de um arquivo
                lineCount++;}
        } catch (IOException e) {throw new RuntimeException(e);}

        if(path.length()>0){
            try (Scanner scanner = new Scanner(new File(path))) { //caminho do arquivo
            while (lineCount>0) {
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
                    reader.setId(id);
                    readerMap.put(id, reader);
                    lineCount-=1;
                    if(id>biggerId){biggerId=id;} //aq pega o maior Id
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);}}

        return biggerId; //retorna o maior Id
    }

    @Override
    public Reader create(Reader obj) {
        long biggerId = recoverData(); //faz a recuperação dos dado no map e retorna o maior Id
        obj.setId(getNextId(biggerId));
        readerMap.put(obj.getId(), obj);
        saveData(); //salva o Hashmap novamento no arquivo
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