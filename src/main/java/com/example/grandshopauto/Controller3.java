package com.example.grandshopauto;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.ENTER;


public class Controller3{

    @FXML
    private  TextField nameKarbari;

    @FXML
    public void initialize() {
        Scanner scan = new Scanner(System.in);
        nameKarbari.setText(scan.nextLine());

    }
}