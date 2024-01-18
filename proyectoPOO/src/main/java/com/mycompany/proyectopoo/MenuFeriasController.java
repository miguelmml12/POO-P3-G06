/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import com.mycompany.proyectopoo.App;
import java.io.IOException;
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
 * @author Josue.jibaja
 */
public class MenuFeriasController implements Initializable {


    @FXML
    private Button guardarBoton;
    @FXML
    private Button cancelarBoton;
    @FXML
    private TextField name;
    @FXML
    private TextField description;
    @FXML
    private TextField place;
    @FXML
    private TextField f_i;
    @FXML
    private TextField f_f;
    @FXML
    private TextField time;
    @FXML
    private TextField s_1;
    @FXML
    private TextField s_2;
    @FXML
    private TextField s_3;
    @FXML
    private TextField s_4;
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
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
