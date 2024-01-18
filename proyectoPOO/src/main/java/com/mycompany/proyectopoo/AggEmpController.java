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
public class AggEmpController implements Initializable {


    @FXML
    public Button botonSiguiente;
    @FXML
    public Button cancelarBoton;
    @FXML
    public TextField idPerson;
    @FXML
    public TextField nombre;
    @FXML
    public TextField telefono;
    @FXML
    public TextField email;
    @FXML
    public TextField direccion;
    @FXML
    public TextField website;
    @FXML
    public TextField personaRes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void irRedes(ActionEvent event) throws IOException {
                 App.setRoot("aggRedesEmp");

    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
                 App.setRoot("menuEmprendedor");
    }

}
