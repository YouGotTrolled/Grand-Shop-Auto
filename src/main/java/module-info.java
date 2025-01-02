module com.example.grandshopauto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grandshopauto to javafx.fxml;
    exports com.example.grandshopauto;
}