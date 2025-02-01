package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.StringTokenizer;

public class Controller2 {

    String temp;
    String user;
    boolean isAdmin;

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private TextField text;

    @FXML
    private ListView<String> border;
    @FXML
    private Button infoButtom;

    PrintWriter writer1;

    @FXML
    public void initialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer tokenizer =new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            user=tokenizer.nextToken();
            tokenizer =new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            isAdmin=Boolean.parseBoolean(tokenizer.nextToken());
            if(isAdmin){
                infoButtom.setText("رابطه کاربری ادمین");
            }else{
                infoButtom.setText("اطلاعات"+user);
            }
            reader.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in controler2");
        }
    }
    @FXML
    public void info (ActionEvent event){
        try{
            if(isAdmin){
                Parent infoadmin = FXMLLoader.load(getClass().getResource("infoAdmin.fxml"));
                Scene scene = new Scene(infoadmin, 1280, 720);
                Stage info1admin = (Stage) ((Node) event.getSource()).getScene().getWindow();
                info1admin.setScene(scene);
                info1admin.show();
            }else {
                Parent info = FXMLLoader.load(getClass().getResource("info1.fxml"));
                Scene scene = new Scene(info, 1280, 720);
                Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                info1.setScene(scene);
                info1.show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void search(ActionEvent event) throws IOException {
        if(!text.getText().isEmpty()) {
            PrintWriter writer=new PrintWriter(new FileOutputStream(".\\systemFiles\\tem.txt"));
            writer.println(text.getText());
            writer.close();
            Parent list1 = FXMLLoader.load(getClass().getResource("search.fxml"));
            Scene scene = new Scene(list1, 1280, 720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }

    }
    public void button1(ActionEvent event){
        try{
            print("all");
            Parent list1 = FXMLLoader.load(getClass().getResource("list1.fxml"));
            Scene scene=new Scene(list1,1280,720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void button2(ActionEvent event){
        try{
            print("benz");
            Parent list1 = FXMLLoader.load(getClass().getResource("list1.fxml"));
            Scene scene=new Scene(list1,1280,720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void button3(ActionEvent event){
        try{
            print("bmw");
            Parent list1 = FXMLLoader.load(getClass().getResource("list1.fxml"));
            Scene scene=new Scene(list1,1280,720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void button4(ActionEvent event){
        try{
            print("audi");
            Parent list1 = FXMLLoader.load(getClass().getResource("list1.fxml"));
            Scene scene=new Scene(list1,1280,720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void button5(ActionEvent event){
        try{
            print("hyundai");
            Parent list1 = FXMLLoader.load(getClass().getResource("list1.fxml"));
            Scene scene=new Scene(list1,1280,720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void button6(ActionEvent event){
        try{
            print("toyota");
            Parent list1 = FXMLLoader.load(getClass().getResource("list1.fxml"));
            Scene scene=new Scene(list1,1280,720);
            Stage list = (Stage) ((Node) event.getSource()).getScene().getWindow();
            list.setScene(scene);
            list.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void print(String berand){
        try {
            writer1 = new PrintWriter((new FileOutputStream(".\\systemFiles\\cBerand.txt")));
            writer1.println(berand);
            writer1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
