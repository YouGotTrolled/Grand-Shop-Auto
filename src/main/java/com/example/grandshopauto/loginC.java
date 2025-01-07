package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class loginC {

    private PrintWriter loger;
    private BufferedReader checker;
    private StringTokenizer tokenizer;


    @FXML
    private TextField username;
    @FXML
    private TextField pasword;
    @FXML
    private Label label;


    @FXML
    public void signUp(ActionEvent actionEvent)  {
        try {
            Parent sign = FXMLLoader.load(getClass().getResource("Sign.fxml"));
            Scene scene=new Scene(sign,1280,720);
            scene.getStylesheets().add(getClass().getResource("SignCSS.css").toExternalForm());
            Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            sign1.setScene(scene);
            sign1.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }


    @FXML
    public void login(ActionEvent actionEvent)  {
        try {
            String bob="";
            boolean tpas = false;
            boolean tekrar = false;
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream("log.txt",true)));
            checker = new BufferedReader(new FileReader("userInfo.txt"));
            String user = username.getText();
            String pass = pasword.getText();
            if (user.isEmpty()){
                label.setText("نام کاربری خود را وارد کنید");
            }
            else if (pass.equals("")) {
                label.setText("رمز عبور خود را وارد کنید");
            }
            else {
                while ((checker.read()) != -1 ) {
                    tokenizer = new StringTokenizer(checker.readLine(), ",[]");
                    if ( user.equals(tokenizer.nextToken()) ) {
                       tekrar = true;
                   }
                    else {
                    }
                    if ( pass.equals(tokenizer.nextToken()) ) {
                        tpas = true;
                    }
                }
                if (!tekrar){
                    label.setText("حسابی با این مشخصات وجود ندارد ، از طریق بخش  ثبت نام یکی ایجاد کنید");
                    bob="حسابی با این مشخصات وجود ندارد ، از طریق بخش  ثبت نام یکی ایجاد کنید";
                }
                else if (!tpas) {
                    label.setText("رمز عبور اشتباه است ");
                    bob="رمز عبور اشتباه است ";
                }
                else  {
                    if (tekrar && tpas ) {
                        bob="با موفقیت وارد سیستم شد";
                        Parent root2= FXMLLoader.load(getClass().getResource("root2.fxml"));
                        Scene scene=new Scene(root2,1280,720);
                        scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
                        Stage login1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        login1.setScene(scene);
                        login1.show();
                    }
                }
            }
            loger.println("("+LocalDateTime.now()+"):"+username.getText()+":\""+bob+"\"");
            loger.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in loginC.java");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in loginC.java");
        }
    }
}