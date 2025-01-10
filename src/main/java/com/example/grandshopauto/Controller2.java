package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Controller2 {
    @FXML
    private ListView<String> border;
    @FXML
    private Button info;
    @FXML
    public void initialize() {
        try {
//            border.getItems().addAll("Item 1", "Item 2", "Item 3");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in controler2");
        }
    }
    @FXML
    public void infoGo(ActionEvent event){
        try{
            Parent sign = FXMLLoader.load(getClass().getResource("info.fxml"));
            Scene scene=new Scene(sign,1280,720);
//            scene.getStylesheets().add(getClass().getResource("CSS.css").toExternalForm());
            Stage sign1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            sign1.setScene(scene);
            sign1.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
