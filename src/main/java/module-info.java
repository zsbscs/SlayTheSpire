module com.example.map {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.dbutils;


    opens com.example.map to javafx.fxml;
    exports com.example.map;

}