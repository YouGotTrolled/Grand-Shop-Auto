package com.example.grandshopauto;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileReader;

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
}