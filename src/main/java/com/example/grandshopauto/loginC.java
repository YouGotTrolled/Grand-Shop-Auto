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
            Parent root2 = FXMLLoader.load(getClass().getResource("root2.fxml"));
            Scene scene=new Scene(root2,1280,720);
            scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
            Stage sign = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            sign.setScene(scene);
            sign.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}