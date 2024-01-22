/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import interfaces.AuspicianteManager;
import interfaces.MenuEmprendedor;
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
import modelo.Emprendedor;
/**
 * FXML Controller class
 *
 * @author angel
 */
public class MenuEmprendedorController implements Initializable {


    @FXML
    private Button nuevoEmp;
    @FXML
    private Button editarEmp;
    @FXML
    private Button salirEmp;
    @FXML
    private VBox xd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Emprendedor emp:MenuEmprendedor.l_emprendedores){
        Label lol = new Label(emp.info());
        HBox k = new HBox();
        k.setAlignment(Pos.CENTER);
        k.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        k.getChildren().add(lol);
        xd.getChildren().add(k);
        }
    }    
    

    @FXML
    private void editarEmp(ActionEvent event) throws IOException {
         App.setRoot("editEmp");
    }

    @FXML
    private void salirEmp(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

    @FXML
    private void nuevoEmp(ActionEvent event) throws IOException {
        App.setRoot("aggEmp");
    }

}
