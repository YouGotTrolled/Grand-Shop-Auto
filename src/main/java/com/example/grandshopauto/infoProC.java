package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class infoProC {

    @FXML
    private Label berand;

    @FXML
    private TextArea detail;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label price;

    @FXML
    private Label stock;

    @FXML
    private Label year;

    @FXML
    private Label quantity;

    @FXML
    private Button infoButtom;

    @FXML
    private Button cardbut;

    @FXML
    private Button cardbutt;

    String pro;

    String user;

    boolean isAdmin;

    PrintWriter plog;

    PrintWriter log;

    @FXML
    private void initialize(){
        try {
            detail.setEditable(false);
            String temp;
            //
            BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            user=tokenizer.nextToken();
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            isAdmin=Boolean.parseBoolean(tokenizer.nextToken());
            reader.close();
            //
            if(isAdmin){
                infoButtom.setText("رابطه کاربری ادمین");
            }else{
                infoButtom.setText("اطلاعات"+user);
            }
            reader.close();
            //
            reader = new BufferedReader(new FileReader(".\\systemFiles\\cPro.txt"));
            pro=reader.readLine();
            reader.close();
            reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\"+pro+"\\proInfo.txt"));
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            name.setText(tokenizer.nextToken());
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            year.setText(tokenizer.nextToken());
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            berand.setText(tokenizer.nextToken());
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            price.setText(tokenizer.nextToken());
            tokenizer=new StringTokenizer(reader.readLine(),":");
            temp=tokenizer.nextToken();
            stock.setText(tokenizer.nextToken());
            if(Integer.parseInt(stock.getText())==0){
                cardbut.setDisable(true);
                cardbutt.setDisable(true);
            }
            reader.close();
            reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\"+pro+"\\proDet.txt"));
            temp= reader.readLine();
            while(temp!=null){
                detail.appendText(temp+"\n");
                temp= reader.readLine();
            }
            reader.close();
            image.setImage(new Image((new File(".\\systemFiles\\products\\"+pro+"\\pic.png")).toURI().toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ATF(ActionEvent event) {
        try {
            if((new File(".\\userInfo\\"+user+"\\fav.txt")).exists()){
                BufferedReader reader = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\fav.txt"));
                String temp = reader.readLine();
                boolean flag = true;
                while(temp != null && flag) {
                    if (pro.equals(temp)) {
                        flag = false;
                    }
                    temp = reader.readLine();
                }
                if (flag) {
                    PrintWriter writer = new PrintWriter(new FileOutputStream(".\\userInfo\\" + user + "\\fav.txt", true));
                    writer.println(pro);
                    writer.close();
                }
            }else {
                PrintWriter writer = new PrintWriter(new FileOutputStream(".\\userInfo\\" + user + "\\fav.txt", true));
                writer.println(pro);
                writer.close();
            }
            log=new PrintWriter(new FileOutputStream(".\\systemFiles\\log.txt",true));
            plog=new PrintWriter(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true));
            log.println("("+ LocalDateTime.now()+"):"+user+":"+pro+"را به لیست مورد علاقه ها اضافه کرد");
            plog.println("("+ LocalDateTime.now()+"):"+user+":"+pro+"را به لیست مورد علاقه ها اضافه کرد");
            log.close();
            plog.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("list1.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }

    @FXML
    private void delete(ActionEvent event) {
        try {
            if((new File(".\\userInfo\\"+user+"\\card.txt")).exists()){
                BufferedReader reader = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\card.txt"));
                int i;
                StringTokenizer tokenizer;
                String temp = reader.readLine();
                boolean flag = true;
                for (i = 1; temp != null && flag; i++) {
                    tokenizer=new StringTokenizer(temp,":");
                    if (pro.equals(tokenizer.nextToken())) {
                        flag = false;
                    }
                    temp = reader.readLine();
                }
                if (!flag) {
                    deleteLineFromFile(--i, (".\\userInfo\\" + user + "\\card.txt"));
                }
            }
            log=new PrintWriter(new FileOutputStream(".\\systemFiles\\log.txt",true));
            plog=new PrintWriter(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true));
            log.println("("+ LocalDateTime.now()+"):"+user+":"+pro+"را از لیست خرید کم کرد");
            plog.println("("+ LocalDateTime.now()+"):"+user+":"+pro+"را از لیست خرید کم کرد");
            log.close();
            plog.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void card(ActionEvent event) {
        try {
            if((new File(".\\userInfo\\"+user+"\\card.txt")).exists()){
                BufferedReader reader = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\card.txt"));
                int i;
                StringTokenizer tokenizer;
                String temp = reader.readLine();
                boolean flag = true;
                boolean flagg = true;
                for (i = 1; temp != null && flag; i++) {
                    tokenizer=new StringTokenizer(temp,":");
                    if (pro.equals(tokenizer.nextToken())) {
                        flag = false;
                    }
                    if (pro.equals(temp)){
                        flagg = false;
                    }
                    temp = reader.readLine();
                }
                if (flag) {
                    PrintWriter writer = new PrintWriter(new FileOutputStream(".\\userInfo\\" + user + "\\card.txt", true));
                    writer.println((pro + ":" + quantity.getText()));
                    writer.close();
                } else if(!flag&&flagg) {
                    changeFile(--i, (pro + ":" + quantity.getText()), (".\\userInfo\\" + user + "\\card.txt"));
                }
            }else {
                PrintWriter writer = new PrintWriter(new FileOutputStream(".\\userInfo\\" + user + "\\card.txt", true));
                writer.println((pro + ":" + quantity.getText()));
                writer.close();
            }
            log=new PrintWriter(new FileOutputStream(".\\systemFiles\\log.txt",true));
            plog=new PrintWriter(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true));
            log.println("("+ LocalDateTime.now()+"):"+user+":"+pro+"("+quantity.getText()+")"+"را به لیست خرید اضافه کرد");
            plog.println("("+ LocalDateTime.now()+"):"+user+":"+pro+"("+quantity.getText()+")"+"را به لیست خرید اضافه کرد");
            log.close();
            plog.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void info(ActionEvent event) throws IOException {
        if(isAdmin){
            Parent info = FXMLLoader.load(getClass().getResource("infoAdmin.fxml"));
            Scene scene = new Scene(info, 1280, 720);
            Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            info1.setScene(scene);
            info1.show();
        }else{
            Parent info = FXMLLoader.load(getClass().getResource("info1.fxml"));
            Scene scene = new Scene(info, 1280, 720);
            Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            info1.setScene(scene);
            info1.show();
        }
    }

    @FXML
    void maines(ActionEvent event) {
        if(Integer.parseInt(quantity.getText())>1){
            quantity.setText(String.valueOf((Integer.parseInt(quantity.getText()))-1));
        }
    }

    @FXML
    void plus(ActionEvent event) {
        if(Integer.parseInt(quantity.getText())<Integer.parseInt(stock.getText())){
            quantity.setText(String.valueOf((Integer.parseInt(quantity.getText()))+1));
        }
    }

    public static void changeFile(int lineNum, String replacement, String file){
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
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void deleteLineFromFile(int lineNum, String file){
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
                }
                read =reader.readLine();
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
