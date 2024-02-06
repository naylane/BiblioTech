module Library {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example to javafx.fxml;
    opens org.example.controller to javafx.fxml;
    exports org.example;
    exports org.example.controller;
    exports org.example.model;
    exports org.example.dao.adm;
    exports org.example.dao.book;
    exports org.example.dao.librarian;
    exports org.example.dao.reader;
    exports org.example.dao.loan;
    opens org.example.dao.adm;
    opens org.example.dao.librarian;
    opens org.example.dao.book;
    opens org.example.dao.loan;
    opens org.example.dao.reader;
    opens org.example.model;

}