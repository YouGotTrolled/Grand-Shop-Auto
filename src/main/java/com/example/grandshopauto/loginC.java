package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class loginC {

    @FXML
    public void signUp(ActionEvent actionEvent) {
        try {
            Parent sign = FXMLLoader.load(getClass().getResource("sign.fxml"));
            Scene scene=new Scene(sign,1280,720);
            scene.getStylesheets().add(getClass().getResource("signCSS.css").toExternalForm());
            Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            sign1.setScene(scene);
            sign1.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}