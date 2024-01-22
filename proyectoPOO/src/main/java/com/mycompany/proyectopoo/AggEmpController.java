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
    
    public  static String cedula;
    public static String name;
    public static String nombrePersona;
    public static String telefone;
    public static String mail;
    public static String direction;
    public static String sitioWeb;
    public static String description;
    
    @FXML
    private TextField descripcion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void irRedes(ActionEvent event) throws IOException {
        
        cedula = idPerson.getText();
         name = nombre.getText();
         nombrePersona = personaRes.getText();
         telefone  = telefono.getText();
         mail = email.getText();
         direction = direccion.getText();
         sitioWeb = website.getText();
         description = descripcion.getText();
        
        //new Emprendedor(cedula, nombre, nombrePersona, telefono, email, direccion, sitioWeb, redesS, description
                 App.setRoot("aggRedesEmp");

    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
                 App.setRoot("menuEmprendedor");
    }

}
