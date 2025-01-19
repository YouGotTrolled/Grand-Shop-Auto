package com.example.grandshopauto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class forgetPasC {

    private PrintWriter loger;
    private BufferedReader checker;
    private StringTokenizer tokenizer;


    @FXML
    private TextField username;
    @FXML
    private TextField ID;
    @FXML
    private Label label;
    @FXML
    private Button fp;
    @FXML
    private Pane noor;
    @FXML
    private Pane noor2;
    @FXML
    private Pane noor3;
    @FXML
    private Pane vnoor;
    @FXML
    private Pane vnoor2;
    @FXML
    private Pane vnoor3;
    @FXML
    private Pane hnoor;
    @FXML
    private Pane hnoor2;
    @FXML
    private Pane hnoor3;

   // private String pUser;

    @FXML
    private void initialize() {
        //fp.setVisible(false);
//        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(3000), event -> {
            int j =0;
            for(int i = 0 ; i < 8000 ; ) {
                j+=600;
                if (i%8==0) {
                    Timeline t2 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { noor.setVisible(true);}));
                    t2.play();
                    Timeline vt2 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor.setVisible(true);}));
                    vt2.play();
                    Timeline ht2 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor.setVisible(true);}));
                    ht2.play();

                    Timeline t3 = new Timeline(new KeyFrame(Duration.millis(j), event3 -> { noor2.setVisible(false);}));
                    t3.play();
                    Timeline vt3 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor2.setVisible(false);}));
                    vt3.play();
                    Timeline ht3 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor2.setVisible(false);}));
                    ht3.play();

                    Timeline t4 = new Timeline(new KeyFrame(Duration.millis(j), event3 -> { noor3.setVisible(false);}));
                    t4.play();
                    Timeline vt4 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor3.setVisible(false);}));
                    vt4.play();
                    Timeline ht4 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor3.setVisible(false);}));
                    ht4.play();
                }
                else{
                    if (i%4==0) {
                        Timeline t22 = new Timeline(new KeyFrame(Duration.millis(j), event4 -> { noor.setVisible(false);}));
                        t22.play();
                        Timeline vt22 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor.setVisible(false);}));
                        vt22.play();
                        Timeline ht22 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor.setVisible(false);}));
                        ht22.play();

                        Timeline t33 = new Timeline(new KeyFrame(Duration.millis(j), event5 -> { noor2.setVisible(true);}));
                        t33.play();
                        Timeline vt33 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor2.setVisible(true);}));
                        vt33.play();
                        Timeline ht33 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor2.setVisible(true);}));
                        ht33.play();

                        Timeline t44 = new Timeline(new KeyFrame(Duration.millis(j), event6 -> { noor3.setVisible(false);}));
                        t44.play();
                        Timeline vt44 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor3.setVisible(false);}));
                        vt44.play();
                        Timeline ht44 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor3.setVisible(false);}));
                        ht44.play();
                    }
                    else {
                        if (i%2==0) {
                            Timeline t222 = new Timeline(new KeyFrame(Duration.millis(j), event7 -> {noor.setVisible(false);}));
                            t222.play();
                            Timeline vt222 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor.setVisible(false);}));
                            vt222.play();
                            Timeline ht222 = new Timeline(new KeyFrame(Duration.millis(j), event4 -> { noor.setVisible(false);}));
                            ht222.play();

                            Timeline t333 = new Timeline(new KeyFrame(Duration.millis(j), event8 -> {noor2.setVisible(false);}));
                            t333.play();
                            Timeline vt333 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor2.setVisible(false);}));
                            vt333.play();
                            Timeline ht333 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor2.setVisible(false);}));
                            ht333.play();

                            Timeline t444 = new Timeline(new KeyFrame(Duration.millis(j), event9 -> {noor3.setVisible(true);}));
                            t444.play();
                            Timeline vt444 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { vnoor3.setVisible(true);}));
                            vt444.play();
                            Timeline ht444 = new Timeline(new KeyFrame(Duration.millis(j), event2 -> { hnoor3.setVisible(true);}));
                            ht444.play();
                        }
                    }
                }
                i+=2;
            }
//        }));
//        t1.play();
    }

    private PrintWriter systemFile;
    @FXML
    public void login(ActionEvent actionEvent)  {
        try {
            systemFile=new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\cUser.txt")));
            String bob="";
            boolean tID = false;
            boolean tekrar = false;
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\log.txt",true)));
            File userCheck;
            String user = username.getText();
            String ID1 = ID.getText();
            String temp;
            if (user.isEmpty()){
                label.setText("نام کاربری خود را وارد کنید");
            }
            else if (ID1.equals("")) {
                label.setText("کد ملی خود را وارد کنید");
            }
            else {
                userCheck=new File(".\\userInfo\\"+user);
                if (!userCheck.exists()){
                    label.setText("حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید");
                    bob="حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید";
                }
                else {
                    checker = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\acInfo.txt"));
                    temp = checker.readLine();
                    temp = checker.readLine();
                    tokenizer = new StringTokenizer(checker.readLine(), ":");
                    temp = tokenizer.nextToken();
                    if (ID.getText().equals(tokenizer.nextToken())) {
                        bob = "با موفقیت وارد سیستم شد";
                        PrintWriter pLogger = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\"+username.getText()+"\\pLog.txt",true)));
                        pLogger.println("(" + LocalDateTime.now() + "):" + username.getText() + ":\""+bob+"\"");
                        pLogger.close();
                        //finding out if is admin
                        for (int i = 0; i < 6; i++) {
                            temp = checker.readLine();
                        }
                        //
                        systemFile.print("username:" + username.getText() + "\n" + temp);
                        systemFile.close();
                        Parent root2 = FXMLLoader.load(getClass().getResource("root2.fxml"));
                        Scene scene = new Scene(root2, 1280, 720);
                        scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
                        Stage login1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        login1.setScene(scene);
                        login1.show();
                    } else {
                        label.setText("رمز عبور اشتباه است ");
                        bob = "رمز عبور اشتباه است ";
                    }
                }
            }
            loger.println("("+ LocalDateTime.now()+"):"+username.getText()+":\""+bob+"\"");
            loger.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in forgetPasC.java");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in forgetPasC.java");
        }
    }
    @FXML
    private void back(ActionEvent actionEvent) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("loginJ.fxml"));
            Scene scene = new Scene(back1, 1280 ,720);
//            scene.getStylesheets().add(getClass().getResource(".css").toExternalForm());
            Stage back2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            back2.setScene(scene);
            back2.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
