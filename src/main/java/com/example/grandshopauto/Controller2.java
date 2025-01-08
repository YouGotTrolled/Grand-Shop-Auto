package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Controller2 {
    @FXML
    private ListView<String> border;
    @FXML
    private Button info;
    @FXML
    public void initialize() {
        try {
            border.getItems().addAll("Item 1", "Item 2", "Item 3");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in controler2");
        }
    }
    @FXML
    public void infoGo(ActionEvent event){

    }
}
