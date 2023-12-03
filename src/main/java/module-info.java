module com.example.increment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.increment to javafx.fxml;
    exports com.example.increment;
}