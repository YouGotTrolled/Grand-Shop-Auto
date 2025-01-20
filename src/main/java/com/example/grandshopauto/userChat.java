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

    //

    @FXML
    private void initialize(){
        try {
            messageArea.setEditable(false);
            reader=new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            user=tokenizer.nextToken();
            tempp=user;
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            admin=Boolean.parseBoolean(tokenizer.nextToken());
            mInfo = new File(".\\userInfo\\"+tempp+"\\messages.txt");
            if (!mInfo.exists()){
                mInfo.createNewFile();
            }
            reader=new BufferedReader(new FileReader(".\\userInfo\\"+tempp+"\\messages.txt"));
            if(admin){
                user="admin";
            }
            temp= reader.readLine();
            while(temp!=null){
                messageArea.appendText(temp+ "\n");
                temp= reader.readLine();
            }
            reader.close();
            messageInput.setOnAction(e -> send());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sendMessage(ActionEvent event) {
        send();
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("info1.fxml"));
            Scene scene = new Scene(back1, 1280 ,720);
            Stage back2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            back2.setScene(scene);
            back2.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deletChat(ActionEvent event) {
            mInfo.delete();
            back(event);
    }

    private void send(){
        try {
            writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\" +tempp+ "\\messages.txt", true)));
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