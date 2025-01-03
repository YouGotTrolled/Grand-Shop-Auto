package com.example.grandshopauto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Image ic = new Image("u.png");
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.getIcons().add(ic);
        stage.setTitle("Grand Shop Auto");
        //scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}