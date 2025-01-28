package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.StringTokenizer;

public class changeinfous {

    @FXML
    private TextField ADD;

    @FXML
    private TextField DOB;

    @FXML
    private TextField ID;

    @FXML
    private TextField Lname;

    @FXML
    private Button SABT;

    @FXML
    private TextField Tpass;

    @FXML
    private Label addError;

    @FXML
    private Label dobError;

    @FXML
    private Label idError;

    @FXML
    private Label lNameError;

    @FXML
    private Label label;

    @FXML
    private Button load;

    @FXML
    private TextField name;

    @FXML
    private Label nameError;

    @FXML
    private TextField num;

    @FXML
    private TextField pass;

    @FXML
    private Label passError;

    @FXML
    private Label phoneError;

    @FXML
    private Label tPassError;

    @FXML
    private TextField username;



    @FXML
    void back(ActionEvent event) {


    }

    @FXML
    private   void sub(ActionEvent event)  {
        try{

        File userCheck = new File(".\\userInfo\\" + username.getText());
        if (!userCheck.exists()){
            lNameError.setText("حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید");

        }
        else {

            TextField [] arr = {pass,ID,DOB,ADD,num,name,Lname};

            BufferedReader checker = new BufferedReader(new FileReader(".\\userInfo\\" + username.getText() + "\\acInfo.txt"));

            int i = 0;
            int p =0;
            String temp;

            while (p<7){
                StringTokenizer tokenizer = new StringTokenizer(checker.readLine() , ":");
                tokenizer.nextToken();
                temp = tokenizer.nextToken();
                if (i!= 0){
                arr [p].setEditable(true);
                arr[p].setText(temp);
                p++;
                }
                i++;}
        }}
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void enter(ActionEvent event){
        try {
        BufferedReader checker = new BufferedReader(new FileReader(".\\userInfo\\" + username.getText() + "\\acInfo.txt"));

        int p =0;

        String [] lines = new String[10];
        StringTokenizer t = new StringTokenizer(checker.readLine() , ":");

        lines[0] = t.nextToken() +":"+ t.nextToken();
        TextField [] arr = {pass,ID,DOB,ADD,num,name,Lname};

        while (p<7){
            String line = checker.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line , ":");
            String temp1 = tokenizer.nextToken();
            String temp2 = tokenizer.nextToken();

            line = temp1 +":" +arr[p].getText();

            lines[p+1] = line;
            p++;

            }
            for (int j = 0; j<2;j++){
                String line = checker.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line , ":");
                lines[p+1] = tokenizer.nextToken() +":"+ tokenizer.nextToken();
                p++;
            }
            PrintWriter systemFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\" + username.getText() + "\\acInfo.txt")));
            for (int i=0;10>i;i++){
                systemFile.println(lines[i]);
            }
            systemFile.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



}
