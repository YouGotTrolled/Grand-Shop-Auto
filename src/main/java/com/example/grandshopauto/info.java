package com.example.grandshopauto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;

public class info {

    @FXML
    private Button cart;

    @FXML
    private Button chat;

    @FXML
    private Button edit;

    @FXML
    private AnchorPane edit_a ;

    @FXML
    private Button fav;

    @FXML
    private Button info;

    @FXML
    private AnchorPane info_a;

    @FXML
    private Button kif;

    @FXML
    private Button lst;

    @FXML
    private Button out;

    @FXML
    private VBox phu2;




    @FXML
    private void switchform(ActionEvent event) {
        if (event.getSource() == info) {
            System.out.println("info");
            info_a.setVisible(true);
            edit_a.setVisible(false);
        } else if (event.getSource() == edit) {
            System.out.println("edit");
            info_a.setVisible(false);
            edit_a.setVisible(true);
        }
        System.out.println("he");
        System.out.println(event.getSource());
    }}
