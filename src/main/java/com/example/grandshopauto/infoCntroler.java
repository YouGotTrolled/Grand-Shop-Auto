package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;

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
    public static void initialize(){

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
