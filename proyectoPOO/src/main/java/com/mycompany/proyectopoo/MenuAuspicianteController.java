/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import interfaces.AuspicianteManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Auspiciante;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MenuAuspicianteController implements Initializable {


    @FXML
    private Button nuevoAus;
    @FXML
    private Button editarAus;
    @FXML
    private Button salirAus;
    @FXML
    private VBox jijija;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Auspiciante aus:AuspicianteManager.auspiciantes){
        Label lol = new Label(aus.info());
        HBox k = new HBox();
        k.setAlignment(Pos.CENTER);
        k.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        k.getChildren().add(lol);
        jijija.getChildren().add(k);
        }// TODO
    }    
    
    @FXML
    private void editarAus(ActionEvent event) {
    }

    @FXML
    private void salirAus(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

    @FXML
    private void nuevoAus(ActionEvent event) throws IOException {
        App.setRoot("agregarAus");
    }

}
