package com.example.grandshopauto;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

import javafx.scene.control.Label;
import javafx.util.Duration;

public class sabadC {


    @FXML
    private ImageView image3;
    @FXML
    private Label name1;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label name6;
    @FXML
    private Label name7;
    @FXML
    private Label name8;
    @FXML
    private Label name9;
    @FXML
    private Label name10;
    @FXML
    private Label name11;
    @FXML
    private Label name12;
    @FXML
    private Label year1;
    @FXML
    private Label year2;
    @FXML
    private Label year3;
    @FXML
    private Label year4;
    @FXML
    private Label year5;
    @FXML
    private Label year6;
    @FXML
    private Label year7;
    @FXML
    private Label year8;
    @FXML
    private Label year9;
    @FXML
    private Label year10;
    @FXML
    private Label year11;
    @FXML
    private Label year12;
    @FXML
    private Label price1;
    @FXML
    private Label price2;
    @FXML
    private Label price3;
    @FXML
    private Label price4;
    @FXML
    private Label price5;
    @FXML
    private Label price6;
    @FXML
    private Label price7;
    @FXML
    private Label price8;
    @FXML
    private Label price9;
    @FXML
    private Label price10;
    @FXML
    private Label price11;
    @FXML
    private Label price12;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    @FXML
    private ImageView image9;
    @FXML
    private ImageView image10;
    @FXML
    private ImageView image11;
    @FXML
    private ImageView image12;
    @FXML
    private StackPane box1;
    @FXML
    private StackPane box2;
    @FXML
    private StackPane box3;
    @FXML
    private StackPane box4;
    @FXML
    private StackPane box5;
    @FXML
    private StackPane box6;
    @FXML
    private StackPane box7;
    @FXML
    private StackPane box8;
    @FXML
    private StackPane box9;
    @FXML
    private StackPane box10;
    @FXML
    private StackPane box11;
    @FXML
    private StackPane box12;
    @FXML
    private Label lastPage;
    @FXML
    private Button infoButtom;
    @FXML
    private Label balance;
    @FXML
    private Label total;

    int numberPage = 0 ;

    int N;

    int page;

    StackPane[] boxs;

    ImageView[] images;

    Label[] names;

    Label[] prices;

    Label[] years;

    int NN = 0;

    String[] tokens;
    String[] tokens2;
    String user;
    boolean isAdmin;
    int totalP=0;

    @FXML
    private void initialize() {
        try {
            String temp;
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
            //
            lastPage.setVisible(false);
            boxs = new StackPane[12];
            boxs[0] = box1;
            boxs[1] = box2;
            boxs[2] = box3;
            boxs[3] = box4;
            boxs[4] = box5;
            boxs[5] = box6;
            boxs[6] = box7;
            boxs[7] = box8;
            boxs[8] = box9;
            boxs[9] = box10;
            boxs[10] = box11;
            boxs[11] = box12;
            images = new ImageView[12];
            images[0] = image1;
            images[1] = image2;
            images[2] = image3;
            images[3] = image4;
            images[4] = image5;
            images[5] = image6;
            images[6] = image7;
            images[7] = image8;
            images[8] = image9;
            images[9] = image10;
            images[10] = image11;
            images[11] = image12;
            names = new Label[12];
            names[0] = name1;
            names[1] = name2;
            names[2] = name3;
            names[3] = name4;
            names[4] = name5;
            names[5] = name6;
            names[6] = name7;
            names[7] = name8;
            names[8] = name9;
            names[9] = name10;
            names[10] = name11;
            names[11] = name12;
            prices = new Label[12];
            prices[0] = price1;
            prices[1] = price2;
            prices[2] = price3;
            prices[3] = price4;
            prices[4] = price5;
            prices[5] = price6;
            prices[6] = price7;
            prices[7] = price8;
            prices[8] = price9;
            prices[9] = price10;
            prices[10] = price11;
            prices[11] = price12;
            years= new Label[12];
            years[0] = year1;
            years[1] = year2;
            years[2] = year3;
            years[3] = year4;
            years[4] = year5;
            years[5] = year6;
            years[6] = year7;
            years[7] = year8;
            years[8] = year9;
            years[9] = year10;
            years[10] = year11;
            years[11] = year12;
            try {
                BufferedReader br = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\card.txt"));
                temp=br.readLine();
                while(temp!=null){
                    NN++;
                    temp=br.readLine();
                }
                if(NN==0){
                    NN=1;
                }
                tokens = new String[NN];
                tokens2 = new String[NN];
                br.close();
                br = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\card.txt"));
                temp=br.readLine();
                for(int i=0; i<NN; i++){
                    tokenizer = new StringTokenizer(temp,":");
                    tokens[i] = tokenizer.nextToken();
                    tokens2[i] = tokenizer.nextToken();
                    temp=br.readLine();
                }
                br.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < tokens.length ; i++ ) {
                reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\" + tokens[i] + "\\proInfo.txt"));
                for(int j=0;j<4;j++)
                    temp = reader.readLine();
                tokenizer=new StringTokenizer(temp,":");
                temp=tokenizer.nextToken();
                temp=tokenizer.nextToken();
                totalP+=((Integer.parseInt(temp))*(Integer.parseInt(tokens2[i])));
                reader.close();
            }
            total.setText(String.valueOf(totalP));
            //
            reader = new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\acInfo.txt"));
            for(int j=0;j<10;j++)
                temp = reader.readLine();
            reader.close();
            tokenizer=new StringTokenizer(temp,":");
            temp=tokenizer.nextToken();
            balance.setText(tokenizer.nextToken());
            reader.close();
            page = (NN/12 + 1);
            loadPage();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("root2.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();

    }
    @FXML
    public void card (ActionEvent event){
        try {
            if (totalP <= Integer.parseInt(balance.getText())) {
                PrintWriter log;
                PrintWriter plog;
                balance.setText(String.valueOf((Integer.parseInt(balance.getText()) - totalP)));
                changeFile(10, "balance:" + balance.getText(), ".\\userInfo\\" + user + "\\acInfo.txt");
                PrintWriter writer = new PrintWriter(new FileOutputStream(".\\userInfo\\" + user + "\\cardH.txt",true));
                BufferedReader reader=new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\card.txt"));
                String temp= reader.readLine();
                while (temp!=null){
                    log=new PrintWriter(new FileOutputStream(".\\systemFiles\\log.txt",true));
                    plog=new PrintWriter(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true));
                    log.println("("+ LocalDateTime.now()+"):"+user+":("+temp+")"+"را خرید");
                    plog.println("("+ LocalDateTime.now()+"):"+user+":("+temp+")"+"را خرید");
                    log.close();
                    plog.close();
                    writer.println(temp);
                    temp= reader.readLine();
                }
                reader.close();
                writer.close();
                (new File(".\\userInfo\\" + user + "\\card.txt")).delete();
                back(event);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
//        try {
//            if (totalP <= Integer.parseInt(balance.getText())) {
//                PrintWriter log;
//                PrintWriter plog;
//                balance.setText(String.valueOf((Integer.parseInt(balance.getText()) - totalP)));
//                changeFile(10, "balance:" + balance.getText(), ".\\userInfo\\" + user + "\\acInfo.txt");
//                PrintWriter writer = new PrintWriter(new FileOutputStream(".\\userInfo\\" + user + "\\cardH.txt",true));
//                BufferedReader reader=new BufferedReader(new FileReader(".\\userInfo\\" + user + "\\card.txt"));
//                String tempp= reader.readLine();
//                String temp = "";
//                int i=0;
//                boolean flag=true;
//                while (tempp!=null){
//                    StringTokenizer tokenizer=new StringTokenizer(temp,":");
//                    String loc=tokenizer.nextToken();
//                    BufferedReader reader2=new BufferedReader(new FileReader(".\\systemFiles\\products\\" + loc + "\\proInfo.txt"));
//                    for(int j=0;j<5;j++)
//                        temp = reader2.readLine();
//                    reader2.close();
//                    StringTokenizer stringTokenizer=new StringTokenizer(temp,":");
//                    temp=stringTokenizer.nextToken();
//                    temp=stringTokenizer.nextToken();
//                    if(Integer.parseInt(tokens2[i])>Integer.parseInt(temp)){
//                        log=new PrintWriter(new FileOutputStream(".\\systemFiles\\log.txt",true));
//                        plog=new PrintWriter(new FileOutputStream(".\\userInfo\\"+user+"\\pLog.txt",true));
//                        log.println("("+ LocalDateTime.now()+"):"+user+":("+tempp+")"+"را خرید");
//                        plog.println("("+ LocalDateTime.now()+"):"+user+":("+tempp+")"+"را خرید");
//                        log.close();
//                        plog.close();
//                        writer.println(tempp);
//
//                    }else if(Integer.parseInt(tokens2[i])==Integer.parseInt(temp)){
//                        deleteLineFromFile(i++,".\\systemFiles\\products\\" + loc + "\\proInfo.txt");
//                    }else{
//
//                    }
//
//                    tempp= reader.readLine();
//                }
//                reader.close();
//                writer.close();
//                back(event);
//            }
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
    @FXML
    public void info (ActionEvent event) throws IOException {
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
    public void next (ActionEvent event) {
        if( numberPage == NN/12 ){
            //پایان صفحه
            lastPage.setVisible(true);
            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(3000), event2 -> { lastPage.setVisible(false);}));
            t2.play();
        }
        else  if (numberPage < page) {
            numberPage+=1;
            loadPage();
        }
    }
    @FXML
    public void back2(ActionEvent event) {
        if (numberPage>=1){
            numberPage--;
            loadPage();
        }
    }
    @FXML
    private void method1() {

    }


    public void loadPage(){
        try {
            System.out.println("*");
            if (numberPage >= page-1 ){
                for (int j = (NN%12) ; j <=11; j++) {
                    boxs[j].setVisible(false);
                }
            }
            if (numberPage < page-1) {
                for (int j = 0 ; j <=11; j++) {
                    boxs[j].setVisible(true);
                }
            }

// ///////
            for (int i = 0; i < 12 && (numberPage * 12 + i) < NN ; i++ ) {
                String temp= "" ;
                File fileimage1 = new File(".\\systemFiles\\products\\" + tokens[i] + "\\pic.png");
                Image image = new Image(fileimage1.toURI().toString());
                images[i].setImage(image);
                BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\" + tokens[i] + "\\proInfo.txt"));
                names[i].setText(reader.readLine() + " ("+tokens2[i]+") ");
                years[i].setText(reader.readLine());
                temp = reader.readLine();
                prices[i].setText(reader.readLine());
                reader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void but1 (ActionEvent event) throws IOException {
        idPrint(1);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but2 (ActionEvent event) throws IOException {
        idPrint(2);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but3 (ActionEvent event) throws IOException {
        idPrint(3);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but4 (ActionEvent event) throws IOException {
        idPrint(4);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but5 (ActionEvent event) throws IOException {
        idPrint(5);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but6 (ActionEvent event) throws IOException {
        idPrint(6);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but7 (ActionEvent event) throws IOException {
        idPrint(7);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but8 (ActionEvent event) throws IOException {
        idPrint(8);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but9 (ActionEvent event) throws IOException {
        idPrint(9);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but10 (ActionEvent event) throws IOException {
        idPrint(10);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but11 (ActionEvent event) throws IOException {
        idPrint(11);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    private void but12 (ActionEvent event) throws IOException {
        idPrint(12);
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    private void idPrint(int i){
        try{
            int j=(numberPage*12)+i-1;
            PrintWriter printWriter=new PrintWriter(new FileOutputStream(".\\systemFiles\\cPro.txt"));
            printWriter.println(tokens[j]);
            printWriter.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
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