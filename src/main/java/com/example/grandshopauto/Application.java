package com.example.grandshopauto;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root1 = new FXMLLoader(Application.class.getResource("root1.fxml"));
        Scene scene = new Scene(root1.load(), 1280, 720);
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