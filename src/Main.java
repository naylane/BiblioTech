import dao.DAO;
import model.*;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // ESCREVENDO NO ARQUIVO
        //Residence address = new Residence("state", "city", "neighbourhood", "street", 0, "cep");
        //Residence address1 = new Residence("state1", "city", "neighbourhood", "street", 44, "cep1");
        //Adm adm = new Adm("name adm", "pin", "phone", address);
        //adm.creatReader("Sara Maria ", "2563", "xx xxxxx-xxxx", address1);

        // LENDO O ARQUIVO E COLOCANDO NO MAP
        System.out.println("\nLENDO E COLOCANDO NO MAP");
        DAO.getReaderDAO().recoverData();

        System.out.println("LENDO O MAP");
        Map<Long, Reader> readerMap = DAO.getReaderDAO().getReaderMap();
        for (Map.Entry<Long, Reader> entry : readerMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
}}
