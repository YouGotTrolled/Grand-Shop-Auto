package com.example.grandshopauto;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class infoProC {

    @FXML
    private Label name;

    @FXML
    private Label information;

    @FXML
    private Label Vmax;

    @FXML
    private Label VS;

    @FXML
    private Label G;

    @FXML
    private Label P;

    @FXML
    private Label A;

    @FXML
    private Label Ms;

    @FXML
    private Label W;

    @FXML
    private Label price;


    @FXML
    public void initialize() {
        try {
            BufferedReader checker1 = new BufferedReader(new FileReader("infopro.txt"));
            BufferedReader checker2 = new BufferedReader(new FileReader("proNum.txt"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
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
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("root2.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();

    }
}