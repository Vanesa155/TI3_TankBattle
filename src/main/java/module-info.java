module com.example.ti3_tankbattle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ti3_tankbattle to javafx.fxml;
    exports com.example.ti3_tankbattle;
}