package com.example.grandshopauto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class info {
        String user;
        int bal3;
        @FXML
        private VBox info_a;

        @FXML
        private VBox cart_;

        @FXML
        private Button cart;

        @FXML
        private Button chat;

        @FXML
        private Button edit;

        @FXML
        private TextField btn_charge;

        @FXML
        private Button charge;

        @FXML
        private Label balance;

        @FXML
        private Button fav;

        @FXML
        private Button info;

        @FXML
        private Button kif;

        @FXML
        private Label DOB;


        @FXML
        private Label ID;

        @FXML
        private Label addr;

        @FXML
        private Label dobAge;

        @FXML
        private Label lastName;

        @FXML
        private Label name;

        @FXML
        private Label num;

        @FXML
        private Button lst;

        @FXML
        private Button out;

    public void initialize(){
        try {
            String temp;
            BufferedReader system = new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer spt=new StringTokenizer(system.readLine(),":");
            temp=spt.nextToken();
            user = spt.nextToken();
            system.close();
            BufferedReader checker = new BufferedReader(new FileReader(".\\userInfo\\"+user+"\\acInfo.txt"));
            int age;
            temp= checker.readLine();
            temp= checker.readLine();
            spt=new StringTokenizer(checker.readLine(),":");
            temp=spt.nextToken();
            ID.setText(spt.nextToken());
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            temp= spt.nextToken();
            DOB.setText(temp);
            temp= String.valueOf(temp.charAt(0))+String.valueOf(temp.charAt(1))+String.valueOf(temp.charAt(2))+String.valueOf(temp.charAt(3));
            age= 1403 - Integer.parseInt(temp);
            dobAge.setText(String.valueOf(age));
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            addr.setText(spt.nextToken());
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            num.setText(spt.nextToken());
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            name.setText(spt.nextToken());
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            lastName.setText(spt.nextToken());
            temp = checker.readLine();
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            temp= spt.nextToken();
            bal3 = Integer.parseInt(temp);
            balance.setText("$"+temp);
            checker.close();
            btn_charge.setOnAction(e -> addBalance());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void charge1(ActionEvent event){
        addBalance();
    }

    @FXML
    void switchform(ActionEvent event) {
        if (event.getSource() == kif){
            cart_.setVisible(true);
            info_a.setVisible(false);

        } else   {
            cart_.setVisible(false);
            info_a.setVisible(true);

        }

    }
    @FXML
    void card(ActionEvent event) {

    }

    @FXML
    private void changeInfo(ActionEvent event) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("changeInfo.fxml"));
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
    void chat(ActionEvent event) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("userChat.fxml"));
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
    void exit(ActionEvent event) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("loginJ.fxml"));
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
    void list1(ActionEvent event) {

    }

    @FXML
    void list2(ActionEvent event) {

    }
    private void addBalance(){
        try {
            PrintWriter pLogger=new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true)));
            PrintWriter loger=new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\log.txt",true)));
            String bal2=btn_charge.getText();
            if (bal2.length()>9){
                bal2 = "1000000000";
            }
            int bal =  Integer.parseInt(bal2);
            if ((bal3+bal) < 1000000001){
                balance.setText("$"+String.valueOf((bal3+bal)));
                changeFile(10,"balance:"+String.valueOf((bal3+bal)),".\\userInfo\\"+user+"\\acInfo.txt");
                bal3=bal3+bal;
            }
            else{
                balance.setText("$"+String.valueOf((1000000000)));
                changeFile(10,"balance:1000000000",".\\userInfo\\"+user+"\\acInfo.txt");
                bal3=1000000000;
            }
            btn_charge.clear();
            pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\"حساب شارژ شد\"");
            loger.println("(" + LocalDateTime.now() + "):" + user+ ":\"حساب شارژ شد\"");
            pLogger.close();
            loger.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void changeFile(int lineNum, String replacement, String file){
        try {
            File temp =new File("temp.txt");
            temp.createNewFile();
            BufferedReader reader=new BufferedReader(new FileReader(file));
            PrintWriter adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream("temp.txt")));
            String read =reader.readLine();
            while(read!=null){
                adder.println(read);
                read =reader.readLine();
            }
            reader.close();
            adder.close();
            reader=new BufferedReader(new FileReader("temp.txt"));
            adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
            int i=1;
            read =reader.readLine();
            while(read!=null){
                if(i!=lineNum){
                    adder.println(read);
                    read =reader.readLine();
                }
                else{
                    adder.println(replacement);
                    read =reader.readLine();
                }
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

}

