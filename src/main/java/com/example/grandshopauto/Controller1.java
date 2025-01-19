package com.example.grandshopauto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class Controller1 {
    @FXML
    private Label title;
    @FXML
    private ImageView logo;
    @FXML
    private void initialize() throws IOException {
        try {
            FadeTransition fadeIn = new FadeTransition(Duration.millis(3000), title);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.setCycleCount(1);
            fadeIn.setAutoReverse(false);
            fadeIn.play();
            FadeTransition fadeIn1 = new FadeTransition(Duration.millis(3000), logo);
            fadeIn1.setFromValue(0.0);
            fadeIn1.setToValue(1.0);
            fadeIn1.setCycleCount(1);
            fadeIn1.setAutoReverse(false);
            fadeIn1.play();
            File userInfo = new File("userInfo");
            File products = new File(".\\systemFiles\\products");
            File log = new File(".\\systemFiles\\log.txt");
            File systemFile = new File("systemFiles");
            File cUser = new File(".\\systemFiles\\cUser.txt");
            if (!userInfo.exists()) {
                userInfo.mkdir();
            }
            if(!systemFile.exists()){
                systemFile.mkdir();
            }
            if (!products.exists()) {
                products.mkdir();
            }
            if(!cUser.exists()){
                systemFile.createNewFile();
            }
            if (!log.exists()) {
                log.createNewFile();
            }
        }
        catch (IOException e){
            System.out.println("error");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}