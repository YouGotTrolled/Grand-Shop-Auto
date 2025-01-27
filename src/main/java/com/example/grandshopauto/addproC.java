package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.StringTokenizer;

public class addproC {

    File picture;

    int ID;

    @FXML
    private Button addPicBut;

    @FXML
    private TextField berand;

    @FXML
    private TextArea detail;

    @FXML
    private Label error;

    @FXML
    private TextField name;

    @FXML
    private ImageView pictureView;

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
    private TextField year;

    @FXML
    private Label yearError;

    @FXML
    public void initialize() {
        error.setText("");
        priceError.setText("");
        yearError.setText("");
        quantityError.setText("");
    }


    @FXML
    void addPicButAction(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        picture=fileChooser.showOpenDialog(new Stage());
        if(picture!=null){
            Image pic=new Image(picture.toURI().toString());
            pictureView.setImage(pic);
        }else{
            error.setText("فایل به درستی انتخاب نشد");
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
            boolean yearFlag = true;
            boolean priceFlag = true;
            boolean quantityFlag = true;
            boolean pictureFlag = true;
            boolean tekrarFlag = true;
            String avalebelety;
            BufferedReader reader;
            StringTokenizer tokenizer;
            int i;
            String temp;
            boolean flag1=true;
            boolean flag2=true;
            error.setText("");
            priceError.setText("");
            yearError.setText("");
            quantityError.setText("");
            //year
            if (charCheckOut(year.getText(), 57, 48)) {
                yearFlag = false;
                yearError.setText("فقط عدد!");
            } else if (!(Integer.parseInt(year.getText()) > 999 && Integer.parseInt(year.getText()) < 2026)) {
                yearFlag = false;
                yearError.setText("عدد غیر مجاز!");
            }
            //price
            if (charCheckOut(price.getText(), 57, 48)) {
                priceFlag = false;
                priceError.setText("فقط عدد!");
            } else if (Integer.parseInt(price.getText()) > 100000) {
                priceFlag = false;
                priceError.setText("عدد غیر مجاز!");
            }
            //quantity
            if (charCheckOut(quantity.getText(), 57, 48)) {
                quantityFlag = false;
                quantityError.setText("فقط عدد مثبت!");
            }
            //Avalebaleity
            if (Integer.parseInt(quantity.getText())>0){
                avalebelety="true";
            }else{
                avalebelety="false";
            }
            //tekrar
            for(i=1;(flag1||flag2)&&yearFlag&&i<=ID;i++){
                flag1=true;
                flag2=true;
                reader=new BufferedReader(new FileReader(".\\systemFiles\\products\\"+i+"\\proInfo.txt"));
                tokenizer=new StringTokenizer(reader.readLine(),":");
                temp=tokenizer.nextToken();
                if(name.getText().equals(tokenizer.nextToken())){
                    flag1=false;
                }
                tokenizer=new StringTokenizer(reader.readLine(),":");
                temp=tokenizer.nextToken();
                if(year.getText().equals(tokenizer.nextToken())){
                    flag2=false;
                }
            }
            if(!(flag1||flag2)){
                tekrarFlag=false;
                error.setText("ثبت شده"+--i+"این محصول قبلا با ای دی ");
            }
            //picture
            if (picture == null) {
                tekrarFlag = false;
                error.setText("عکس نزاشتی");
            }
            //
            if (priceFlag && quantityFlag && yearFlag && tekrarFlag) {
                getID();
                File productDir = new File(".\\systemFiles\\products\\" + ID);
                productDir.mkdir();
                PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\products\\" + ID + "\\proInfo.txt")));
                writer.println("name:"+name.getText()+"\nyear:"+year.getText()+"\nberand:"+berand.getText()+"\nprice:"+price.getText()+"\nquantity:"+quantity.getText()+"\navalebelety:"+avalebelety);
                writer.close();
                writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\products\\" + ID + "\\proDet.txt")));
                writer.println(detail.getText());
                writer.close();
                Path destinationPath = Path.of(".\\systemFiles\\products\\" + ID, "pic.png");
                Files.copy(picture.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
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
    private void getID(){
        File products = new File(".\\systemFiles\\products");
        String[] productCount=products.list();
        if (productCount != null) {
            ID=productCount.length+1;
        }else{
            ID=1;
        }
    }
}
