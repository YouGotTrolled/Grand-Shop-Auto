package com.example.grandshopauto;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class infoAdminC {

    @FXML
    private Label DOB;

    @FXML
    private Label ID;

    @FXML
    private Label addr;

    @FXML
    private Label lastName;

    @FXML
    private Label name;

    @FXML
    private Label num;

    @FXML
    private void initialize() {
        try {
            String temp;
            String user;
            BufferedReader system = new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer spt = new StringTokenizer(system.readLine(), ":");
            temp = spt.nextToken();
            user = spt.nextToken();
            system.close();
            BufferedReader checker = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\acInfo.txt"));
            temp = checker.readLine();
            temp = checker.readLine();
            spt = new StringTokenizer(checker.readLine(), ":");
            temp = spt.nextToken();
            ID.setText(spt.nextToken());
            spt = new StringTokenizer(checker.readLine(), ":");
            temp = spt.nextToken();
            DOB.setText(spt.nextToken());
            spt = new StringTokenizer(checker.readLine(), ":");
            temp = spt.nextToken();
            addr.setText(spt.nextToken());
            spt = new StringTokenizer(checker.readLine(), ":");
            temp = spt.nextToken();
            num.setText(spt.nextToken());
            spt = new StringTokenizer(checker.readLine(), ":");
            temp = spt.nextToken();
            name.setText(spt.nextToken());
            spt = new StringTokenizer(checker.readLine(), ":");
            temp = spt.nextToken();
            lastName.setText(spt.nextToken());
            checker.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("root2.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void addpro(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("addpro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void exit(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("loginJ.fxml"));
        Scene scene = new Scene(login, 1280, 720);
        Stage login1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login1.setScene(scene);
        login1.show();
    }
    @FXML
    void editInfo(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("editPro.fxml"));
        Scene scene = new Scene(login, 1280, 720);
        Stage login1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login1.setScene(scene);
        login1.show();
    }
    @FXML
    void edituser(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("changeinfous.fxml"));
        Scene scene = new Scene(login, 1280, 720);
        Stage login1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login1.setScene(scene);
        login1.show();
    }
    @FXML
    private void chat(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("userChat.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void log(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("adminLog.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
}