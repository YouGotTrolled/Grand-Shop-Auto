package com.example.grandshopauto;


import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class addproC{

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
    public void initialize(){

    }

    @FXML
    public void signpro (ActionEvent actionEvent) {
        try {
            String name1 = name.getText();
            String berand1 = berand.getText();
            String price1 = price.getText();
            String year1 = year.getText();
            String information1 = information.getText();


            PrintWriter systemFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".txt")));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}