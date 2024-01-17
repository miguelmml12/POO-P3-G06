/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;


import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class MenuPrincipalController implements Initializable {


    @FXML
    private Button botonF;
    @FXML
    private Button botonE;
    @FXML
    private Button botonA;
    @FXML
    private Button botonS;
    @FXML
    private Button botonSalir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void abrirFer(ActionEvent event)throws IOException {
            App.setRoot("primary");
    }

        
    @FXML
    private void abrirEmp(ActionEvent event) {
    }

    @FXML
    private void abrirAus(ActionEvent event) {
    }

    @FXML
    private void abrirStands(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
    }

}
