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

    private BufferedReader checker;

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
            boolean flagg = true;
            boolean flaggg = true;
            boolean flagggg = true;
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream("log.txt",true)));
            checker=new BufferedReader(new FileReader("userInfo.txt"));
            String tuser=user.getText();
            String ttuser;
            String pass = pas.getText();
            String bob="نام کاربری تکراری است";
            if(checker.readLine()==null) {
                flag=false;
            }
            while(flag&&checker.readLine()!=null) {
                spt = new StringTokenizer(checker.readLine(), ",[]");
                ttuser = spt.nextToken();
                if (!tuser.equals(ttuser)) {
                    flag = false;
                }
            }
            if(flagg&&!flag){
                for(int i=0;i<pass.length();i++){
                    if((int) pass.charAt(i) >57&&(int)pass.charAt(i)<48){
                        bob="رمز عدد ندارد";
                        flagg=false;
                    }
                    if((int) pass.charAt(i) >122&&(int)pass.charAt(i)<97){
                        bob = "رمز حرف کوچک ندارد";
                        flagg=false;
                    }
                    if((int) pass.charAt(i) >90&&(int)pass.charAt(i)<65){
                        bob="رمز حرف بزرگ ندارد";
                        flagg=false;
                    }
                    if((int) pass.charAt(i) >38&&(int)pass.charAt(i)<33){
                        bob="رمز کاراکتر خاص ندارد ندارد";
                        flagg=false;
                    }
                    if(!flagg){
                        flagg=true;
                    }
                    else{
                        flagg=false;
                    }

                }
            }
            if(flaggg&&!flagg){
                if(!(pass.equals(Tpas.getText()))){
                    bob="رمز ها یکی نیستن";
                }
                else {
                    flagggg=false;
                }
            }
            label.setText(bob);
            if(!flagggg){
                checker.close();
                adder=new PrintWriter(new BufferedOutputStream(new FileOutputStream("userInfo.txt",true)));
                adder.println("["+user.getText()+","+pas.getText()+","+ID.getText()+","+DOB.getText()+","+ADD.getText()+","+num.getText()+","+name.getText()+","+Lname.getText()+"]");
                adder.close();
                bob="ثبت نام با موفقیت انجام شد با اطلاعات:"+"["+user.getText()+","+pas.getText()+","+ID.getText()+","+DOB.getText()+","+ADD.getText()+","+num.getText()+","+name.getText()+","+Lname.getText()+"]";
                Parent sign = FXMLLoader.load(getClass().getResource("root2.fxml"));
                Scene scene=new Scene(sign,1280,720);
                scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
                Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                sign1.setScene(scene);
                sign1.show();
            }
            loger.println("("+LocalDateTime.now()+"):"+tuser+":\""+bob+"\"");
            loger.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in SingC.java");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in SingC.java");
        }
    }
}