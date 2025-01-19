package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.util.StringTokenizer;

public class infoCntroler {
    @FXML
    private Label DOB;

    @FXML
    private Label Id;

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
    void info(ActionEvent event) {

    }

    @FXML
    public void initialize(){
        try {
            String temp;
            BufferedReader system = new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer spt=new StringTokenizer(system.readLine(),":");
            temp=spt.nextToken();
            String user = spt.nextToken();
            system.close();
            BufferedReader checker = new BufferedReader(new FileReader(".\\userInfo\\"+user+"\\acInfo.txt"));
            int age;
            temp= checker.readLine();
            temp= checker.readLine();
            spt=new StringTokenizer(checker.readLine(),":");
            temp=spt.nextToken();
            Id.setText(spt.nextToken());
            spt=new StringTokenizer(checker.readLine(),":");
            temp= spt.nextToken();
            temp= spt.nextToken();
            DOB.setText(temp);
            temp= String.valueOf(temp.charAt(0))+String.valueOf(temp.charAt(1))+String.valueOf(temp.charAt(2))+String.valueOf(temp.charAt(3));
            age= 1403 - Integer.parseInt(temp);
            dobAge.setText("age="+age);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void infoC(ActionEvent actionEvent) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("changeInfo.fxml"));
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

    @FXML
    private void sendChat(ActionEvent event) {
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
