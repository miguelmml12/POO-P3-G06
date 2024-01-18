/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import interfaces.*;
import static interfaces.StandManager.menuStand;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.Feria;
import modelo.Stand;

/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class MenuStandsController implements Initializable {

    @FXML
    private Button buscar;
    @FXML
    private TextField textboxCodeFer;
    @FXML
    private VBox tablaStands;
    @FXML
    private Button volver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscar(ActionEvent event) {
        int codFer= Integer.valueOf(textboxCodeFer.getText());
        if(MenuFeria.buscarFeriaPorCodigo(codFer) != null){
          Feria fer = MenuFeria.buscarFeriaPorCodigo(codFer);
          HBox frame1 = new HBox();
          frame1.setAlignment(Pos.CENTER);
          for (Stand stand : fer.seccion1) {
              Label name = new Label(stand.getCodigo());
              frame1.getChildren().add(name);
        }
          HBox frame2 = new HBox();
          frame2.setAlignment(Pos.CENTER);
        for (Stand stand : fer.seccion2) {
            Label name = new Label(stand.getCodigo());
              frame2.getChildren().add(name);
        }
        HBox frame3 = new HBox();
        frame3.setAlignment(Pos.CENTER);
        for (Stand stand : fer.seccion3) {
            Label name = new Label(stand.getCodigo());
              frame3.getChildren().add(name);
        }
        HBox frame4 = new HBox();
        frame4.setAlignment(Pos.CENTER);
        for (Stand stand : fer.seccion4) {
            Label name = new Label(stand.getCodigo());
              frame4.getChildren().add(name);
        }
        Button bt = new Button("Asignar Stand");
        Button btn = new Button("Consultar Stand");
        tablaStands.getChildren().addAll(frame1,frame2,frame3,frame4,bt,btn);
      } 
       else {
//        System.out.println("Feria no encontrada");

      }      
    }
        

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }
    
}
