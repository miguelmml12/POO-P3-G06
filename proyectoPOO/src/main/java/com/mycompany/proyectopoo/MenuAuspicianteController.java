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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void editarAus(ActionEvent event) {
    }

    @FXML
    private void salirAus(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
