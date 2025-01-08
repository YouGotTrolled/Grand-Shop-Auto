package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class SignC {
    private PrintWriter loger;

    private BufferedReader checker;

    private PrintWriter adder;

    private StringTokenizer spt;

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
    private TextField user;
    @FXML
    private TextField pas;
    @FXML
    private TextField Tpas;
    @FXML
    private Label label;
    @FXML
    public void sub(ActionEvent actionEvent) {
        try {
            boolean flag=true;
            boolean flagPas1 = true;
            boolean flagPas2 = true;
            boolean flagPas3 = true;
            boolean flagPas4 = true;
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream("log.txt",true)));
            checker=new BufferedReader(new FileReader("userInfo.txt"));
            String bob="نام کاربری تکراری است";
            for(int i=0;(flag)&&i<user.getText().length();i++){
                if(user.getText().isEmpty()||(int)user.getText().charAt(i)>122||((int)user.getText().charAt(i)>90&&(int)user.getText().charAt(i)<97)||((int)user.getText().charAt(i)>57&&(int)user.getText().charAt(i)<65)||(int)user.getText().charAt(i)<48){
                    flag=false;
                    bob="یوزرنیم فقط میتواند عدد و حروف انگلیسی باشد";
                }
            }
            if(flag) {
                while (flag && checker.read()!=-1) {
                    spt = new StringTokenizer(checker.readLine(), ",[]");
                    if (user.getText().equals(spt.nextToken())) {
                        flag= false;
                    }
                }
            }
            if(flag){
                flagPas1=!(charCheck(pas.getText(),48,57));
                if (flagPas1){
                    bob="رمز عدد ندارد";
                }
                flagPas2=!(charCheck(pas.getText(),97,122));
                if (flagPas2){
                    bob = "رمز حرف کوچک انگلیسی ندارد";
                }
                flagPas3=!(charCheck(pas.getText(),65,90));
                if (flagPas3){
                    bob="رمز حرف بزرگ انگلیسی ندارد";
                }
                flagPas4=!(charCheck(pas.getText(),33,38));
                if (flagPas4){
                    bob="رمز کاراکتر خاص ندارد ندارد";
                }
                if (flagPas4||flagPas3||flagPas2||flagPas1){
                    flag=false;
                }
            }
            if(flag){
                for (int i = 0; (flag) && i < pas.getText().length(); i++) {
                    if ((int) pas.getText().charAt(i) > 122 || ((int) pas.getText().charAt(i) > 90 && (int) pas.getText().charAt(i) < 97) || ((int) pas.getText().charAt(i) > 57 && (int) pas.getText().charAt(i) < 65) || ((int) pas.getText().charAt(i) > 38 && (int) pas.getText().charAt(i) < 48)|| (int) pas.getText().charAt(i) < 33) {
                        flag = false;
                        bob = "رمز فقط میتواند عدد و حروف انگلیسی و حروف خاص باشد";
                    }
                }
            }
            if(flag) {
                if (!(pas.getText().equals(Tpas.getText()))) {
                    bob = "رمز ها یکی نیستن";
                    flag = false;
                }
            }
            if(flag){
                flag=!((charCheckOut(name.getText(),1740,1570)&&!charCheck(name.getText(),32,32))||name.getText().isEmpty());
                if(!flag){
                    bob="نام فقط باید حروف فارسی باشد";
                }
            }
            if(flag){
                flag=!((charCheckOut(Lname.getText(),1740,1570)&&!charCheck(Lname.getText(),32,32))||Lname.getText().isEmpty());
                if(!flag){
                    bob="نام خوانوادگی فقط باید حروف فارسی باشد";
                }
            }
            if(flag){
                flag=!(charCheckOut(ID.getText(),57,48)||ID.getText().isEmpty());
                if(!flag){
                    bob="کد ملی فقط باید عدد باشد";
                }
            }
            if(flag){
                flag=!(((charCheckOut(DOB.getText(),57,48)&&!charCheck(DOB.getText(),47,47))) || DOB.getText().isEmpty()) || DOB.getText().charAt(5)!='/'|| DOB.getText().charAt(8)!='/';
                if(!flag){
                    bob="تاریخ تولد فقط باید عدد و / باشد";
                }
            }
            if(flag){
                flag=!(charCheckOut(num.getText(),57,48)||num.getText().isEmpty());
                if(!flag){
                    bob="شماره فقط باید عدد باشد";
                }
            }
            if(flag){
                if(ADD.getText().isEmpty()){
                    flag=false;
                }
                for(int i=0;flag&&i<ADD.getText().length();i++) {
                    if (ADD.getText().charAt(i) == '[' || ADD.getText().charAt(i) == ']' || ADD.getText().charAt(i) == ',') {
                        flag = false;
                        bob = "از کاراکتر های غیر مجاز در ادرس استفاده نکنید یا ادرس داده نشد";
                    }
                }
            }
            label.setText(bob);
            if(flag){
                checker.close();
                adder=new PrintWriter(new BufferedOutputStream(new FileOutputStream("userInfo.txt",true)));
                adder.println("["+user.getText()+","+pas.getText()+","+ID.getText()+","+DOB.getText()+","+ADD.getText()+","+num.getText()+","+name.getText()+","+Lname.getText()+"]");
                adder.close();
                bob="ثبت نام با موفقیت انجام شد با اطلاعات:"+"["+user.getText()+","+pas.getText()+","+ID.getText()+","+DOB.getText()+","+ADD.getText()+","+num.getText()+","+name.getText()+","+Lname.getText()+"]";
                Parent sign = FXMLLoader.load(getClass().getResource("root2.fxml"));
                Scene scene=new Scene(sign,1280,720);
                scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
                Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                sign1.setScene(scene);
                sign1.show();
            }
            loger.println("("+LocalDateTime.now()+"):"+user.getText()+":\""+bob+"\"");
            loger.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in SingC.java");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("("+ LocalDateTime.now()+"):\""+e.getMessage()+"\"in SingC.java");
        }
    }
    private boolean charCheck (String a,int b,int c){
        boolean an=false;
        for(int i=0;(!an)&&i<a.length();i++){
            if((int)a.charAt(i)>=b&&(int)a.charAt(i)<=c){
                an=true;
            }
        }
        return an;
    }
    private boolean charCheckOut (String a,int b,int c){
        boolean an=false;
        for(int i=0;(!an)&&i<a.length();i++){
            if((int)a.charAt(i)>b||(int)a.charAt(i)<c){
                an=true;
            }
        }
        return an;
    }

}