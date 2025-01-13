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

public class SignC {
    private PrintWriter loger;

    private BufferedReader checker;

    private PrintWriter adder;

    private StringTokenizer spt;

    private PrintWriter systemFile;

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
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream("log.txt", true)));
            checker = new BufferedReader(new FileReader("userInfo.txt"));
            systemFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream("systemFile.txt")));
            String bob;
            //userFlag
            for (int i = 0; (userFlag) && i < user.getText().length(); i++) {
                if (user.getText().isEmpty() || (int) user.getText().charAt(i) > 122 || ((int) user.getText().charAt(i) > 90 && (int) user.getText().charAt(i) < 97) || ((int) user.getText().charAt(i) > 57 && (int) user.getText().charAt(i) < 65) || (int) user.getText().charAt(i) < 48) {
                    userFlag = false;
                    bob = "یوزرنیم فقط میتواند عدد و حروف انگلیسی باشد";
                }
            }
            if (userFlag) {
                while (userFlag && checker.read() != -1) {
                    spt = new StringTokenizer(checker.readLine(), ",[]");
                    if (user.getText().equals(spt.nextToken())) {
                        userFlag = false;
                        bob = "نام کاربری تکراری است";
                    }
                }
            }
            //passwordFlag
            for (int i = 0; (passFlag) && i < pas.getText().length(); i++) {
                if ((int) pas.getText().charAt(i) > 122 || ((int) pas.getText().charAt(i) > 90 && (int) pas.getText().charAt(i) < 97) || ((int) pas.getText().charAt(i) > 57 && (int) pas.getText().charAt(i) < 65) || ((int) pas.getText().charAt(i) > 38 && (int) pas.getText().charAt(i) < 48) || (int) pas.getText().charAt(i) < 33) {
                    passFlag = false;
                    bob = "رمز فقط میتواند عدد و حروف انگلیسی و حروف خاص باشد";
                }
            }
            if (passFlag) {
                flagPas1 = !(charCheck(pas.getText(), 48, 57));
                if (flagPas1) {
                    bob = "رمز عدد ندارد";
                }
                flagPas2 = !(charCheck(pas.getText(), 97, 122));
                if (flagPas2) {
                    bob = "رمز حرف کوچک انگلیسی ندارد";
                }
                flagPas3 = !(charCheck(pas.getText(), 65, 90));
                if (flagPas3) {
                    bob = "رمز حرف بزرگ انگلیسی ندارد";
                }
                flagPas4 = !(charCheck(pas.getText(), 33, 38));
                if (flagPas4) {
                    bob = "رمز کاراکتر خاص ندارد ندارد";
                }
                if (flagPas4 || flagPas3 || flagPas2 || flagPas1) {
                    passFlag = false;
                }
            }
            //rePassFlagg
            if (!(pas.getText().equals(Tpas.getText()))) {
                bob = "رمز ها یکی نیستن";
                rePassFlag = false;
            }
            //nameFlag
            nameFlag = !((charCheckOut(name.getText(), 1740, 1570) && !charCheck(name.getText(), 32, 32)) || name.getText().isEmpty());
            if (!nameFlag) {
                bob = "نام فقط باید حروف فارسی باشد";
            }
            //lNameFlag
            lNameFlag = !((charCheckOut(Lname.getText(), 1740, 1570) && !charCheck(Lname.getText(), 32, 32)) || Lname.getText().isEmpty());
            if (!lNameFlag) {
                bob = "نام خوانوادگی فقط باید حروف فارسی باشد";
            }
            //idFlag
            idFlag = !(charCheckOut(ID.getText(), 57, 48) || ID.getText().isEmpty());
            if (!idFlag) {
                bob = "کد ملی فقط باید عدد باشد";
            }
            //birthFlag
            if (DOB.getText().isEmpty()) {
                birthFlag = false;
                bob = "تاریخ تولد را وارد کنید";
            }
            if (birthFlag) {
                birthFlag = !(charCheckOut(DOB.getText(), 57, 48) && !charCheck(DOB.getText(), 47, 47)) || DOB.getText().charAt(5) != '/' || DOB.getText().charAt(8) != '/';
                if (!birthFlag) {
                    bob = "تاریخ تولد فقط باید عدد و / باشد";
                }
            }
            //phoneFlag
            phoneFlag = !(charCheckOut(num.getText(), 57, 48) || num.getText().isEmpty());
            if (!phoneFlag) {
                bob = "شماره فقط باید عدد باشد";
            }
            //addFlag
            if (ADD.getText().isEmpty()) {
                addFlag = false;
                bob = "ادرس داده نشد";
            }
            for (int i = 0; addFlag && i < ADD.getText().length(); i++) {
                if (ADD.getText().charAt(i) == '[' || ADD.getText().charAt(i) == ']' || ADD.getText().charAt(i) == ',') {
                    addFlag = false;
                    bob = "از کاراکتر های غیر مجاز در ادرس استفاده نکنید";
                }
            }
            //
            bob = "خطا در ثبت نام";
            label.setText(bob);
            if (userFlag && passFlag && rePassFlag && nameFlag && lNameFlag && addFlag && idFlag && phoneFlag && birthFlag) {
                checker.close();
                adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream("userInfo.txt", true)));
                adder.println("[" + user.getText() + "," + pas.getText() + "," + ID.getText() + "," + DOB.getText() + "," + ADD.getText() + "," + num.getText() + "," + name.getText() + "," + Lname.getText() + "]");
                adder.close();
                systemFile.print(user.getText());
                systemFile.close();
                bob = "ثبت نام با موفقیت انجام شد با اطلاعات:" + "[" + user.getText() + "," + pas.getText() + "," + ID.getText() + "," + DOB.getText() + "," + ADD.getText() + "," + num.getText() + "," + name.getText() + "," + Lname.getText() + "]";
                Parent sign = FXMLLoader.load(getClass().getResource("root2.fxml"));
                Scene scene = new Scene(sign, 1280, 720);
                scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
                Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                sign1.setScene(scene);
                sign1.show();
            }
            loger.println("(" + LocalDateTime.now() + "):" + user.getText() + ":\"" + bob + "\"");
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
            Parent back1 = FXMLLoader.load(getClass().getResource("loginJ.fxml"));
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
}