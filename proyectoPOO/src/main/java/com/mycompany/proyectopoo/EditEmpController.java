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
/**
 * FXML Controller class
 *
 * @author angel
 */
public class EditEmpController implements Initializable {


    @FXML
    private Button botonSiguiente;
    @FXML
    private Button cancelarBoton;
    @FXML
    private TextField idPerson;
    @FXML
    private TextField nombre;
    @FXML
    private TextField telefono;
    @FXML
    private TextField email;
    @FXML
    private TextField direccion;
    @FXML
    private TextField website;
    @FXML
    private TextField personaRes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void irEditRedes(ActionEvent event) throws IOException {
        App.setRoot("editRedesEmp");
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("menuEmprendedor");
    }

}
