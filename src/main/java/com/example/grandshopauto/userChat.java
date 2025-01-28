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
                if((new File(".\\systemFiles\\adminChatNotification.txt")).exists()) {
                    reader = new BufferedReader(new FileReader(".\\systemFiles\\adminChatNotification.txt"));
                    temp=reader.readLine();
                    if(temp!=null){
                        messageArea.appendText("new message(s) from:\n");
                    }
                    while(temp!=null){
                        messageArea.appendText(temp+"\n");
                        temp=reader.readLine();
                    }
                }
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
            deleteNotification(userLoc);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sendMessage(ActionEvent event) {
        if(admin){
            if(!loadUser.getText().isEmpty()) {
                File userF = new File(".\\userInfo\\" + loadUser.getText());
                if (userF.exists()) {
                    send(loadUser.getText());
                } else {
                    messageArea.appendText("user not found\n");
                }
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
                (new File(".\\userInfo\\" + loadUser.getText() + "\\notification")).delete();
                deleteNotification(loadUser.getText());
            }else{
                messageArea.appendText("user not found\n");
            }
        }else{
            mInfo.delete();
            deleteNotification(user);
            (new File(".\\userInfo\\" + user + "\\notification")).delete();
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
            if(admin) {
                (new File(".\\userInfo\\" + userLoc + "\\notification")).createNewFile();
            }else{
                if((new File(".\\systemFiles\\adminChatNotification.txt")).exists()){
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(".\\systemFiles\\adminChatNotification.txt"));
                    temp=bufferedReader.readLine();
                    boolean isHere=false;
                    while(!(temp==null||isHere)){
                        if(userLoc.equals(temp)){
                            isHere=true;
                        }
                        temp=bufferedReader.readLine();
                    }
                    bufferedReader.close();
                    if(!isHere){
                        notification(userLoc);
                    }
                }else{
                    notification(userLoc);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void notification(String user1){
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(".\\systemFiles\\adminChatNotification.txt", true));
            printWriter.println(user1.toLowerCase());
            printWriter.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLineFromFile(int lineNum, String file){
        try {
            File temp =new File(".\\systemFiles\\temp.txt");
            temp.createNewFile();
            BufferedReader reader=new BufferedReader(new FileReader(file));
            PrintWriter adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\temp.txt")));
            String read =reader.readLine();
            while(read!=null){
                adder.println(read);
                read =reader.readLine();
            }
            reader.close();
            adder.close();
            reader=new BufferedReader(new FileReader(".\\systemFiles\\temp.txt"));
            adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
            int i=1;
            read =reader.readLine();
            while(read!=null){
                if(i!=lineNum){
                    adder.println(read);
                }
                read =reader.readLine();
                i++;
            }
            reader.close();
            adder.close();
            temp.delete();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    private void deleteNotification(String user1){
        try {
            reader = new BufferedReader(new FileReader(".\\systemFiles\\adminChatNotification.txt"));
            temp = reader.readLine();
            boolean isHere = false;
            int i = 1;
            while (!(temp == null || isHere)) {
                if (user1.toLowerCase().equals(temp)) {
                    isHere = true;
                }
                temp = reader.readLine();
                i++;
            }
            if (isHere)
                deleteLineFromFile(--i, ".\\systemFiles\\adminChatNotification.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}