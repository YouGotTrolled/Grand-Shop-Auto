package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Label ademp;

    @FXML
    private Label bremp;

    @FXML
    private Label idemp;

    @FXML
    private Label nemp;

    @FXML
    private Label nemp1;

    @FXML
    private Label nemp2;
    @FXML
    private Label nemp3;

    @FXML
    private Label remp;

    @FXML
    private Label lenp;
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
    private Label nemp31;

    @FXML
    private Label nemp311;

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
        Label[] arrl = {remp,idemp,bremp,ademp,nemp3,nemp,lenp};

        while (p<7){
            String line = checker.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line , ":");
            String temp1 = tokenizer.nextToken();
            String temp2 = tokenizer.nextToken();



                arrl[p].setVisible(false);
                nemp1.setVisible(false);
                nemp311.setVisible(false);
                nemp31.setVisible(false);
                nemp2.setVisible(false);



            if(!ID.getText().isEmpty()){
                boolean idFlag = !(charCheckOut(ID.getText(), 57, 48));
                if (!idFlag) {
                    nemp1.setVisible(true);
                }
                if(ID.getText().length()!=10){
                    nemp311.setVisible(true);
                }}
            if(!num.getText().isEmpty()){
                boolean idFlag = !(charCheckOut(num.getText(), 57, 48));
                if (!idFlag) {
                    nemp2.setVisible(true);
                }
                if(num.getText().length()!=11){
                    nemp31.setVisible(true);
                }}


            if (arr[p].getText().isEmpty()){
                arrl[p].setVisible(true);
                lines[p+1] = line;
                p++;
                continue;
            }

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

    @FXML
    void back(ActionEvent event) {
        try {
            Parent info = FXMLLoader.load(getClass().getResource("infoAdmin.fxml"));
            Scene scene = new Scene(info, 1280, 720);
            Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            info1.setScene(scene);
            info1.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    private boolean charCheckOut(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) > b || (int) a.charAt(i) < c) {
                an = true;
            }
        }
        return an;
    }



}
