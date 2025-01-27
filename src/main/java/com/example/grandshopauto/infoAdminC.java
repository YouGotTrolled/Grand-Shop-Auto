package com.example.grandshopauto;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class infoAdminC {

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
    private void addpro(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("addpro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void exit(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("loginJ.fxml"));
        Scene scene = new Scene(login, 1280, 720);
        Stage login1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login1.setScene(scene);
        login1.show();
    }
    @FXML
    void editInfo(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("editPro.fxml"));
        Scene scene = new Scene(login, 1280, 720);
        Stage login1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login1.setScene(scene);
        login1.show();
    }
}