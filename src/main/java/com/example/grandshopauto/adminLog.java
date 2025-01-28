package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class adminLog {

    @FXML
    private TextField loadUser;

    @FXML
    private TextArea messageArea;

    @FXML
    private void initialize() {
        messageArea.appendText("\"all\" for log.txt\nusername for username\\pLog.txt\n");
        loadUser.setOnAction(e -> loadUserButton(e));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent back1 = FXMLLoader.load(getClass().getResource("infoAdmin.fxml"));
        Scene scene = new Scene(back1, 1280 ,720);
        Stage back2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        back2.setScene(scene);
        back2.show();
    }

    @FXML
    void loadUserButton(ActionEvent event) {
        File userF = new File(".\\userInfo\\" + loadUser.getText());
        messageArea.clear();
        if(loadUser.getText().equals("all")){
            load(".\\systemFiles\\log.txt");
        }else if(userF.exists()){
            load(".\\userInfo\\" + loadUser.getText() + "\\pLog.txt");
        }else{
            messageArea.appendText("wrong input\n");
        }
    }

    private void load(String logLoc){
        try {
            String temp;
            messageArea.clear();
            BufferedReader reader = new BufferedReader(new FileReader(logLoc));
            temp = reader.readLine();
            while (temp != null) {
                messageArea.appendText(temp + "\n");
                temp = reader.readLine();
            }
            reader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
