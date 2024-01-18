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
 * @author angel
 */
public class MenuEmprendedorController implements Initializable {


    @FXML
    private Button nuevoEmp;
    @FXML
    private Button editarEmp;
    @FXML
    private Button salirEmp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void editarEmp(ActionEvent event) throws IOException {
         App.setRoot("aggEmprendedor");
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
