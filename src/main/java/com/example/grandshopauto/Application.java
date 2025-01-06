package com.example.grandshopauto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root1 = new FXMLLoader(Application.class.getResource("root1.fxml"));
        Scene scene1 = new Scene(root1.load(), 1280, 720);
        scene1.getStylesheets().add(getClass().getResource("app1.css").toExternalForm());
        Image ic = new Image("u.png");
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.getIcons().add(ic);
        stage.setTitle("Grand Shop Auto");
        stage.setScene(scene1);
        stage.show();
        FXMLLoader root2 = new FXMLLoader(Application.class.getResource("root3.fxml"));
        Scene scene2 = new Scene(root2.load(), 1280, 720);
        scene2.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), event -> {stage.setScene(scene2);}));
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}