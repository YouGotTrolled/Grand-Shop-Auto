package com.example.grandshopauto;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class search {

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
    private TextField box;


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

    Integer[] ids = new Integer[100];

    int page;

    StackPane[] boxs;

    ImageView[] images;

    Label[] names;

    Label[] prices;

    Label[] years;

    int p = 0;
    @FXML
    private void initialize() {
        try {
            BufferedReader r = new BufferedReader(new FileReader(".\\systemfiles\\tem.txt"));
            box.setText(r.readLine());
            r.close();
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
            File products = new File(".\\systemFiles\\products");
            String[] productCount=products.list();
            if(productCount!=null) {
                N = productCount.length;
            }else{
                N=0;
            }
            method1(new ActionEvent());
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
        Parent info = FXMLLoader.load(getClass().getResource("info1.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    public void but1 (ActionEvent event) throws IOException {
        Parent info = FXMLLoader.load(getClass().getResource("infopro.fxml"));
        Scene scene = new Scene(info, 1280, 720);
        Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        info1.setScene(scene);
        info1.show();
    }
    @FXML
    public void next (ActionEvent event) {
        if( numberPage == p/12 ){//پایان صفحه
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
    private void method1(ActionEvent event) {
        try{


        for(int i = 1; N>i;i++){
            BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\" + i  + "\\proInfo.txt"));

            StringTokenizer tokenizer=new StringTokenizer(reader.readLine(),":");
            tokenizer.nextToken();
            String temp=tokenizer.nextToken();
            if (temp.contains(box.getText())){
                ids[i-1] = i;
                p++;
            }}

            page = (p/12 + 1);
            loadPage();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadPage(){
        try {

            if (numberPage == page-1 ){
                for (int j = (p%12) ; j <=11; j++) {
                    boxs[j].setVisible(false);
                }
            }
            if (numberPage < page-1) {
                for (int j = 0 ; j <=11; j++) {
                    boxs[j].setVisible(true);
                }
            }
            int yes = 0;
            for (int i = 0; i < 12 && (numberPage * 12 + i) < N ; i++) {


                String temp="";

                if(Arrays.asList(ids).contains(numberPage * 12 + i+1)) {
                    File fileimage1 = new File(".\\systemFiles\\products\\" + ((numberPage * 12) + i + 1) + "\\pic.png");
                    Image image = new Image(fileimage1.toURI().toString());
                    boxs[yes].setVisible(true);
                    images[yes].setImage(image);
                    BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\products\\" + ((numberPage * 12) + i + 1) + "\\proInfo.txt"));
                    names[yes].setText(reader.readLine());
                    years[yes].setText(reader.readLine());
                    temp = reader.readLine();
                    prices[yes].setText(reader.readLine());
                    yes++;
                }
            } p = 0; ids  = new Integer[N];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
