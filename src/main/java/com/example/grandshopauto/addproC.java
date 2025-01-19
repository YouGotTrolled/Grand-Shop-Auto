package com.example.grandshopauto;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class addproC{

    private BufferedReader checker;
    private PrintWriter adder;


    @FXML
    private TextField name;

    @FXML
    private TextField year;

    @FXML
    private TextField berand;

    @FXML
    private TextField information;

    @FXML
    private TextField price;

    @FXML
    private Button sapt;

    @FXML
    public void initialize(){

    }

    @FXML
    public void signpro (ActionEvent actionEvent) {
        try {

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sapt (ActionEvent actionEvent) {
        try {
            checker.close();
            adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream("products.txt", true)));
            adder.println("[" + name.getText() + "," + berand.getText() + "," + price.getText() + "," + year.getText() + "," + information.getText() + "]");
            adder.close();
//            systemFile.print(user.getText());
//            systemFile.close();
//            bob = "ثبت نام با موفقیت انجام شد با اطلاعات:" + "[" + name.getText() + "," + berand.getText() + "," + price.getText() + "," + year.getText() + "," + information.getText() + "]";
//            Parent sign = FXMLLoader.load(getClass().getResource(".fxml"));
//            Scene scene = new Scene(sign, 1280, 720);
//            scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
//            Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            sign1.setScene(scene);
//            sign1.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}