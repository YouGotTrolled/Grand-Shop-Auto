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
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class infoChancher {
    private PrintWriter loger;

    private String user;

    private BufferedReader reader;

    @FXML
    private TextField name;
    @FXML
    private TextField Lname;
    @FXML
    private TextField ID;
    @FXML
    private TextField ADD;
    @FXML
    private TextField DOB;
    @FXML
    private TextField num;
    @FXML
    private TextField pass;
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
    private Label nameError;
    @FXML
    private Label passError;
    @FXML
    private Label phoneError;
    @FXML
    private Label tPassError;
    @FXML
    private void initialize() {
        try {
            reader = new BufferedReader(new FileReader(".\\systemFiles\\cUser.txt"));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(),":");
            String temp = tokenizer.nextToken();
            user=tokenizer.nextToken();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void sub(ActionEvent actionEvent) {
        try {
            //flags
            boolean flagPas1 = true;
            boolean flagPas2 = true;
            boolean flagPas3 = true;
            boolean flagPas4 = true;
            boolean userFlag = true;
            boolean passFlag = true;
            boolean rePassFlag = true;
            boolean nameFlag = true;
            boolean lNameFlag = true;
            boolean idFlag = true;
            boolean phoneFlag = true;
            boolean addFlag = true;
            boolean birthFlag = true;
            //
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\log.txt", true)));
            PrintWriter pLogger = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true)));
            //start
            nameError.setText("");
            lNameError.setText("");
            passError.setText("");
            tPassError.setText("");
            addError.setText("");
            idError.setText("");
            phoneError.setText("");
            dobError.setText("");
            //password
            if(!pass.getText().isEmpty()||!Tpass.getText().isEmpty()){
                if(!pass.getText().isEmpty()&&!Tpass.getText().isEmpty()){
                    for (int i = 0; (passFlag) && i < pass.getText().length(); i++) {
                        if ((int) pass.getText().charAt(i) > 122 || ((int) pass.getText().charAt(i) > 90 && (int) pass.getText().charAt(i) < 97) || ((int) pass.getText().charAt(i) > 57 && (int) pass.getText().charAt(i) < 65) || ((int) pass.getText().charAt(i) > 38 && (int) pass.getText().charAt(i) < 48) || (int) pass.getText().charAt(i) < 33) {
                            passFlag = false;
                            passError.setText("رمز فقط میتواند عدد و حروف انگلیسی و حروف خاص باشد");
                        }
                    }
                    if (passFlag) {
                        flagPas1 = !(charCheck(pass.getText(), 48, 57));
                        if (flagPas1) {
                            passError.setText("رمز عدد ندارد");
                        }
                        flagPas2 = !(charCheck(pass.getText(), 97, 122));
                        if (flagPas2) {
                            passError.setText("رمز حرف کوچک انگلیسی ندارد");
                        }
                        flagPas3 = !(charCheck(pass.getText(), 65, 90));
                        if (flagPas3) {
                            passError.setText("رمز حرف بزرگ انگلیسی ندارد");
                        }
                        flagPas4 = !(charCheck(pass.getText(), 33, 38));
                        if (flagPas4) {
                            passError.setText("رمز کاراکتر خاص ندارد ندارد");
                        }
                        if (flagPas4 || flagPas3 || flagPas2 || flagPas1) {
                            passFlag = false;
                        }
                        if (rePassFlag&&!(pass.getText().equals(Tpass.getText()))) {
                            tPassError.setText("رمز ها یکی نیستن");
                            rePassFlag = false;
                        }
                        if(passFlag&&rePassFlag){
                            changeFile(2,"password:"+pass.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                            passError.setText("رمز با موفقیت عوض شد");
                            pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+passError.getText()+"\"");
                            loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+passError.getText()+"\"");
                        }
                    }
                }else{
                    if(pass.getText().isEmpty()) {
                        passError.setText("فیلد خالی است");
                    }
                    if(Tpass.getText().isEmpty()) {
                        tPassError.setText("فیلد خالی است");
                    }
                }
            }
            //name
            if(!name.getText().isEmpty()){
                nameFlag = !((charCheckOut(name.getText(), 1740, 1570) && !charCheck(name.getText(), 32, 32)));
                if (!nameFlag) {
                    nameError.setText("نام فقط باید حروف فارسی باشد");
                }else {
                    changeFile(7,"name:"+name.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                    nameError.setText("نام با موفقیت عوض شد");
                    pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+nameError.getText()+"\"");
                    loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+nameError.getText()+"\"");
                }
            }
            //lName
            if(!Lname.getText().isEmpty()){
                lNameFlag = !((charCheckOut(Lname.getText(), 1740, 1570) && !charCheck(Lname.getText(), 32, 32)));
                if (!lNameFlag) {
                    lNameError.setText("نام خوانوادگی فقط باید حروف فارسی باشد");
                }else{
                    changeFile(8,"last name:"+Lname.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                    lNameError.setText("نام خوانوادگی با موفقیت عوض شد");
                    pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+lNameError.getText()+"\"");
                    loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+lNameError.getText()+"\"");
                }
            }
            //id
            if(!ID.getText().isEmpty()){
                idFlag = !(charCheckOut(ID.getText(), 57, 48));
                if (!idFlag) {
                    idError.setText("کد ملی فقط باید عدد باشد");
                }
                else if(ID.getText().length()!=10){
                    idFlag=false;
                    idError.setText("شماره فقط باید 10 رقم باشد");

                }else{
                    changeFile(3,"id:"+ID.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                    idError.setText("کد ملی با موفقیت عوض شد");
                    pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+idError.getText()+"\"");
                    loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+idError.getText()+"\"");
                }
            }
            //birth
            if (!DOB.getText().isEmpty()) {
                if (birthFlag && DOB.getText().length() != 10) {
                    birthFlag = false;
                    dobError.setText("غیر قابل قبول");
                }
                else if(birthFlag && (charCheckOut(DOB.getText(), 57, 47) || DOB.getText().charAt(4) != '/' || DOB.getText().charAt(7) != '/')) {
                    dobError.setText("تاریخ تولد فقط باید عدد و / باشد");
                    birthFlag = false;
                }else{
                    changeFile(4,"date of birth:"+DOB.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                    dobError.setText("تاریخ تولد با موفقیت عوض شد");
                    pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+dobError.getText()+"\"");
                    loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+dobError.getText()+"\"");
                }
            }
            //phone
            if(!num.getText().isEmpty()){
                phoneFlag = !(charCheckOut(num.getText(), 57, 48));
                if (!phoneFlag) {
                    phoneError.setText("شماره فقط باید عدد باشد");
                }
                else if(num.getText().length()!=11){
                    phoneFlag=false;
                    phoneError.setText("شماره فقط باید 11 رقم باشد");

                }else{
                    changeFile(6,"phone number:"+Lname.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                    phoneError.setText("شماره با موفقیت عوض شد");
                    pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+phoneError.getText()+"\"");
                    loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+phoneError.getText()+"\"");
                }
            }
            //add
            if (!ADD.getText().isEmpty()) {
                for (int i = 0; addFlag && i < ADD.getText().length(); i++) {
                    if (ADD.getText().charAt(i) == ':') {
                        addFlag = false;
                        addError.setText("از کاراکتر های غیر مجاز در ادرس استفاده نکنید");
                    }
                }
                if(addFlag){
                    changeFile(5,"address:"+ADD.getText(),".\\userInfo\\"+user+"\\acInfo.txt");
                    addError.setText("ادرس با موفقیت عوض شد");
                    pLogger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+addError.getText()+"\"");
                    loger.println("(" + LocalDateTime.now() + "):" + user+ ":\""+addError.getText()+"\"");
                }
            }
            //
            pLogger.close();
            loger.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
            loger.println("(" + LocalDateTime.now() + "):\"" + e.getMessage() + "\"in SingC.java");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("(" + LocalDateTime.now() + "):\"" + e.getMessage() + "\"in SingC.java");
        }
    }

    private boolean charCheck(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) >= b && (int) a.charAt(i) <= c) {
                an = true;
            }
        }
        return an;
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

    @FXML
    private void back(ActionEvent actionEvent) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("info.fxml"));
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
}