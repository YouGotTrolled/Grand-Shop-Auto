package com.example.grandshopauto;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class list1C {





    @FXML
    private void initialize() {

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("root2.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();

    }
    @FXML
    public void info (ActionEvent event){
        try{
//            if(isAdmin){
//                Parent infoadmin = FXMLLoader.load(getClass().getResource("infoAdmin.fxml"));
//                Scene scene = new Scene(infoadmin, 1280, 720);
//                Stage info1admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                info1admin.setScene(scene);
//                info1admin.show();
//            }else {
                Parent info = FXMLLoader.load(getClass().getResource("info1.fxml"));
                Scene scene = new Scene(info, 1280, 720);
                Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                info1.setScene(scene);
                info1.show();
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void but1 (ActionEvent event) {
        try {
//            if(isAdmin){
//                Parent info = FXMLLoader.load(getClass().getResource("admin.fxml"));
//                Scene scene = new Scene(info, 1280, 720);
//                Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                info1.setScene(scene);
//                info1.show();
//            }else {
            Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
            Scene scene = new Scene(info, 1280, 720);
            Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            info1.setScene(scene);
            info1.show();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}