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

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author angel
 */
public class AggRedesEmpController implements Initializable {


    @FXML
    private Button botonSiguiente;
    @FXML
    private Button cancelarBoton;
    @FXML
    private TextField tw;
    @FXML
    private TextField fb;
    @FXML
    private TextField ig;
    @FXML
    private TextField tiktok;
    @FXML
    private TextField linkedln;
    @FXML
    private TextField yt;
    @FXML
    private TextField pinterest;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void guardar(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

}
