module com.example.grandshopauto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.grandshopauto to javafx.fxml;
    exports com.example.grandshopauto;
}