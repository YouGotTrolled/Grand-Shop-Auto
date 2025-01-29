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
import java.util.StringTokenizer;

import javafx.scene.control.Label;
import javafx.util.Duration;

public class list1C {


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

    int numberPage = 0 ;

    int N;

    int page;

    StackPane[] boxs;

    ImageView[] images;

    Label[] names;

    Label[] prices;

    Label[] years;

    String[] AAA = new String[100];

    String temp;

    String user;

    boolean isAdmin;

    @FXML
    private Button infoButtom;

    @FXML
    private void initialize() {
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
            years = new Label[12];
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

            BufferedReader checker = new BufferedReader(new FileReader(".\\systemFiles\\cBerand.txt"));
            temp = checker.readLine();
            checker.close();

            if (temp.equals("all")) {
                File products = new File(".\\systemFiles\\products");
                String[] productCount = products.list();
                if (productCount != null) {
                    N = productCount.length;
                } else {
                    N = 0;
                }
            }
            else {
                BufferedReader benz1 = new BufferedReader(new FileReader(".\\systemFiles\\berands\\" +temp+ ".txt"));
                int l = 0;
                AAA[l] = benz1.readLine();
                while ( AAA[l] != null ) {
                    l+=1;
                    AAA[l] = benz1.readLine();
                }
                benz1.close();
                N = l ;
            }
            page = (N / 12 + 1);
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
        if( numberPage == N/12 ){//پایان صفحه
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

    @FXML
    private void card(ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("card.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }

    public void loadPage(){
        try {
            if (numberPage == page-1 ){
                for (int j = (N%12) ; j <=11; j++) {
                    boxs[j].setVisible(false);
                }
            }
            if (numberPage < page-1) {
                for (int j = 0 ; j <=11; j++) {
                    boxs[j].setVisible(true);
                }
            }
            if(temp.equals("all")) {
                for (int i = 0; i < 12 && (numberPage * 12 + i) < N; i++) {
                    String temp = "";
                    File fileimage1 = new File(".\\systemFiles\\products\\" + ((numberPage * 12) + i + 1) + "\\pic.png");
                    Image image = new Image(fileimage1.toURI().toString());
                    images[i].setImage(image);
                    BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\" + ((numberPage * 12) + i + 1) + "\\proInfo.txt"));
                    names[i].setText(reader.readLine());
                    years[i].setText(reader.readLine());
                    temp = reader.readLine();
                    prices[i].setText(reader.readLine());
                    reader.close();
                }
            }
            else {
                for(int i = 0 ; i < N && i < 12 ; i++){
//                    int num = Integer.parseInt(AAA[i]);
                    File fileimage2 = new File(".\\systemFiles\\products\\" + AAA[i] + "\\pic.png");
                    Image image = new Image(fileimage2.toURI().toString());
                    images[i].setImage(image);
                    BufferedReader reader2 = new BufferedReader(new FileReader(".\\systemFiles\\products\\" + AAA[i] + "\\proInfo.txt"));
                    names[i].setText(reader2.readLine());
                    years[i].setText(reader2.readLine());
                    temp = reader2.readLine();
                    prices[i].setText(reader2.readLine());
                    reader2.close();
                }
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
            if(AAA[j]!=null) {
                printWriter.println(AAA[j]);
            }else{
                printWriter.println((j+1));
            }
            printWriter.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}