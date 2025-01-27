package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.StringTokenizer;

public class editPro {

    @FXML
    private TextField ID;

    @FXML
    private CheckBox avalebale;

    @FXML
    private TextArea detail;

    @FXML
    private Label error;

    @FXML
    private TextField price;

    @FXML
    private Label priceError;

    @FXML
    private TextField quantity;

    @FXML
    private Label quantityError;

    @FXML
    private Button submit;

    @FXML
    public void initialize() {
        avalebale.setDisable(true);
        error.setText("");
        priceError.setText("");
        quantityError.setText("");
    }
    @FXML
    void load(ActionEvent event) {
        try {
            detail.clear();
            String temp="";
            error.setText("");
            priceError.setText("");
            quantityError.setText("");
            BufferedReader reader=new BufferedReader(new FileReader(".\\systemFiles\\products\\" + ID.getText() + "\\proInfo.txt"));
            for(int i=0;i<4;i++)
                temp= reader.readLine();
            StringTokenizer tokenizer=new StringTokenizer(temp,":");
            temp=tokenizer.nextToken();
            price.setText(tokenizer.nextToken());
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            quantity.setText(tokenizer.nextToken());
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            avalebale.setSelected(Boolean.parseBoolean(tokenizer.nextToken()));
            reader.close();
            reader=new BufferedReader(new FileReader(".\\systemFiles\\products\\" + ID.getText() + "\\proDet.txt"));
            temp= reader.readLine();
            while(temp!=null){
                detail.appendText(temp+"\n");
                temp= reader.readLine();
            }
            reader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            error.setText("ای دی وجود ندارد");
        } catch (IOException e) {
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

    @FXML
    void signpro(ActionEvent event) {
        try {
            boolean priceFlag = true;
            boolean quantityFlag = true;
            error.setText("");
            priceError.setText("");
            quantityError.setText("");
            //price
            if (charCheckOut(price.getText(), 57, 48)) {
                priceFlag = false;
                priceError.setText("فقط عدد!");
            } else if (Integer.parseInt(price.getText()) > 100000) {
                priceFlag = false;
                priceError.setText("عدد غیر مجاز!");
            }else{
                changeFile(4,"price:"+price.getText(),".\\systemFiles\\products\\" + ID.getText() + "\\proInfo.txt");
            }
            //quantity
            if (charCheckOut(quantity.getText(), 57, 48)) {
                quantityFlag = false;
                quantityError.setText("فقط عدد مثبت!");
            }else {
                changeFile(5,"quantity:"+quantity.getText(),".\\systemFiles\\products\\" + ID.getText() + "\\proInfo.txt");
            }
            if(quantityFlag) {
                if (Integer.parseInt(quantity.getText()) == 0) {
                    changeFile(6, "avalebelety:false", ".\\systemFiles\\products\\" + ID.getText() + "\\proInfo.txt");
                    avalebale.setSelected(false);
                } else {
                    changeFile(6, "avalebelety:true", ".\\systemFiles\\products\\" + ID.getText() + "\\proInfo.txt");
                    avalebale.setSelected(true);
                }
            }
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\products\\" + ID.getText() + "\\proDet.txt")));
            writer.println(detail.getText());
            writer.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            error.setText("ای دی وجود ندارد");

        }catch (Exception e) {
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
    public void changeFile(int lineNum, String replacement, String file){
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
            error.setText("ای دی وجود ندارد");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
