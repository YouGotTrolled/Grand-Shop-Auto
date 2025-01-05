package com.example.grandshopauto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller1 {
    @FXML
    private Label title;
    @FXML
    private ImageView logo;
    @FXML
    private void initialize() {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2500), title);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        fadeIn.play();
        FadeTransition fadeIn1 = new FadeTransition(Duration.millis(2500), logo);
        fadeIn1.setFromValue(0.0);
        fadeIn1.setToValue(1.0);
        fadeIn1.setCycleCount(1);
        fadeIn1.setAutoReverse(false);
        fadeIn1.play();
    }
}