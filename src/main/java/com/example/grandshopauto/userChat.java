package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class userChat {
    //variables

    String user;

    boolean admin;

    BufferedReader reader;

    PrintWriter writer;

    String temp;

    String tempp;

    File mInfo;

    @FXML
    private TextArea messageArea;

    @FXML
    private TextField messageInput;

    @FXML
    private TextField loadUser;

    @FXML
    private Button loadUserButtomItself;

    //

    @FXML
    private void initialize(){
        try {
            messageArea.setEditable(false);
            //
            reader=new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            user=tokenizer.nextToken();
            tempp=user;
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            admin=Boolean.parseBoolean(tokenizer.nextToken());
            reader.close();
            //
            if(!admin){
                loadUserButtomItself.setVisible(false);
                loadUser.setVisible(false);
                load(user);
            }else{
                user="admin";
            }
            //
            messageInput.setOnAction(e -> sendMessage(e));
            loadUser.setOnAction(e -> loadUserButton(e));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load(String userLoc){
        try {
            messageArea.clear();
            mInfo = new File(".\\userInfo\\" + userLoc + "\\messages.txt");
            if (!mInfo.exists()) {
                mInfo.createNewFile();
            }
            reader = new BufferedReader(new FileReader(".\\userInfo\\" + userLoc + "\\messages.txt"));

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

    @FXML
    private void sendMessage(ActionEvent event) {
        if(admin){
            File userF = new File(".\\userInfo\\" + loadUser.getText());
            if (userF.exists()) {
                send(loadUser.getText());
            }else{
                messageArea.appendText("user not found\n");
            }
        }else{
            send(user);
        }
    }

    @FXML
    void loadUserButton(ActionEvent event) {
        File userF = new File(".\\userInfo\\" + loadUser.getText());
        if (userF.exists()) {
            load(loadUser.getText());
        }else{
            messageArea.appendText("user not found\n");
        }
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            if (admin) {
                Parent back1 = FXMLLoader.load(getClass().getResource("infoAdmin.fxml"));
                Scene scene = new Scene(back1, 1280 ,720);
                Stage back2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                back2.setScene(scene);
                back2.show();
            }else{
                Parent back1 = FXMLLoader.load(getClass().getResource("info1.fxml"));
                Scene scene = new Scene(back1, 1280 ,720);
                Stage back2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                back2.setScene(scene);
                back2.show();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deletChat(ActionEvent event) {
        if(admin){
            File userF = new File(".\\userInfo\\" + loadUser.getText());
            if (userF.exists()) {
                load(loadUser.getText());
                mInfo.delete();
                back(event);
            }else{
                messageArea.appendText("user not found\n");
            }
        }else{
            mInfo.delete();
            back(event);
        }
    }

    private void send(String userLoc){
        try {
            writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\" +userLoc+ "\\messages.txt", true)));
            String message = messageInput.getText();
            messageArea.appendText("(" + LocalDateTime.now() + "):" + user + ":" + message + "\n");
            writer.println("(" + LocalDateTime.now() + "):" + user + ":" + message);
            messageInput.clear();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}