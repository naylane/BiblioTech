package dao.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import model.Reader;
import model.Residence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderDAOImpl implements ReaderDAO {
    private Map<Long, Reader> readerMap = new HashMap<>();
    private long nextId = 0;

    public long getNextId() {
        /*
         * A++ -> usa o valor de A e depois incrementa A
         * ++A -> incrementa o valor de A e depois utiliza o valor de A
         */
        return this.nextId++; // retorna ID para o objeto atual e define o próximo ID
    }

    public void saveData() {
        String csvFilePath = "./data/reader.csv"; // caminho do arquivo CSV
        try (FileWriter writter = new FileWriter(csvFilePath)) { // "escritor"

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

    public void recoverData() {
        Map<Long, Reader> mapRecovered = new HashMap<>();

        try (CSVReader csvReader = new CSVReader(new FileReader("./data/reader.csv"))) {
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                if (record.length >= 10) {
                    long id = Long.parseLong(record[0].trim());
                    String name = record[1].trim();
                    String pin = record[2].trim();
                    String phone = record[3].trim();
                    String state = record[4].trim();
                    String city = record[5].trim();
                    String neighbourhood = record[6].trim();
                    String street = record[7].trim();
                    int number = Integer.parseInt(record[8].trim());
                    String cep = record[9].trim();

                    Residence address = new Residence(state, city, neighbourhood, street, number, cep);
                    Reader reader = new Reader(name, pin, phone, address);
                    mapRecovered.put(id, reader);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        this.readerMap = mapRecovered;
    }

    @Override
    public Reader create(Reader obj){
        obj.setId(getNextId());
        readerMap.put(obj.getId(), obj);
        saveData();
        return obj;
    }

    @Override
    public List<Reader> findAll() {
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public Reader findById(long id) {
        return readerMap.get(id);
    }

    @Override
    public Reader update(Reader obj) {
        readerMap.put(obj.getId(), obj);
        return obj;
    }

    @Override
    public void delete(Reader obj) {
        readerMap.remove(obj.getId());
    }

    @Override
    public void deleteAll() {
        readerMap.clear();
    }

    public Map<Long, Reader> getReaderMap() {
        return readerMap;
    }
}