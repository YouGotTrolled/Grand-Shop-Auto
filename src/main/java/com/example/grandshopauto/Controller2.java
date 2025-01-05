package com.example.grandshopauto;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller2 {
    @FXML
    private ListView<String> border;
    @FXML
    public void initialize() {
        border.getItems().addAll("Item 1", "Item 2", "Item 3");
    }
}
