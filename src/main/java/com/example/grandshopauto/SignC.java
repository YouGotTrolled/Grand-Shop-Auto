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

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SignC {
    private PrintWriter loger;

    private Scanner checker;

    private PrintWriter adder;

    private StringTokenizer spt;

    @FXML
    private TextField name;
    @FXML
    private TextField Lname;
    @FXML
    private TextField ID;
    @FXML
    private TextField ADD;
    @FXML
    private TextField DOB;
    @FXML
    private TextField num;
    @FXML
    private TextField user;
    @FXML
    private TextField pas;
    @FXML
    private TextField Tpas;
    @FXML
    private Label label;
    @FXML
    public void sub(ActionEvent actionEvent) {
        try {
            boolean flag = true;
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream("log.txt",true)));
            checker=new Scanner("userInfo.txt");
            String tuser=user.getText();
            String ttuser;
            while(!flag&&checker.hasNextLine()){
                spt=new StringTokenizer(checker.nextLine()," ,[]");
                ttuser= spt.nextToken();
                if(tuser.equals(ttuser)){
                    flag=false;
                }
            }
            if(flag){
                

            }
            else{
                label.setText("نام کاربری تکراری است");
                loger.println("("+ LocalDateTime.now()+"):"+tuser+"دوباره تلاش کرد که ثبت نام کند");
            }




            loger.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in SingC.java");
        }
    }
}