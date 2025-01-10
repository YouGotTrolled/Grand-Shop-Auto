package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
            BufferedReader system = new BufferedReader(new FileReader("systemFile.txt"));
            BufferedReader checker = new BufferedReader(new FileReader("userInfo.txt"));
            StringTokenizer spt;
            boolean userFlag=true;
            String user = system.readLine();
            system.close();
            String temp;
            int age;
            while (userFlag&&checker.read()!=-1) {
                spt = new StringTokenizer(checker.readLine(), ",[]");
                if (user.equals(spt.nextToken())) {
                    userFlag= false;
                }
                if(!userFlag){
                    temp=spt.nextToken();
                    Id.setText(spt.nextToken());
                    temp= spt.nextToken();
                    DOB.setText(temp);
                    temp= String.valueOf(temp.charAt(0))+String.valueOf(temp.charAt(1))+String.valueOf(temp.charAt(2))+String.valueOf(temp.charAt(3));
                    age= 1403 - Integer.parseInt(temp);
                    dobAge.setText("age="+age);
                    name.setText(spt.nextToken());
                    lastName.setText(spt.nextToken());
                    num.setText(spt.nextToken());
                    addr.setText(spt.nextToken());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
