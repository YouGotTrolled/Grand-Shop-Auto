//package com.example.grandshopauto;
//
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import java.util.Scanner;
//
//
//public class loginC {
//
//    @FXML
//    private Button login;
//
//    @FXML
//    private void onLogin() {
//
//    }
//
//    @FXML
//    private  TextField nameKarbari;
//
//    @FXML
//    public void initialize() {
//        Scanner scan = new Scanner(System.in);
//        nameKarbari.setText(scan.nextLine());
//
//    }
//}
package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class loginC {

    @FXML
    public void signUp(ActionEvent actionEvent) {
        try {
            FXMLLoader root2 = new FXMLLoader(Application.class.getResource("loginJ.fxml"));
            Scene scene3 = new Scene(root2.load(), 1280, 720);
            scene3.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());

            Stage sign = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            sign.setScene(scene3);
            sign.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}