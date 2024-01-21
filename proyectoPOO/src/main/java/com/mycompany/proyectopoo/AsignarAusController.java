/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import interfaces.MenuFeria;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Feria;

/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class AsignarAusController implements Initializable {

    @FXML
    private ComboBox<String> ferias_box;
    @FXML
    private TextField id;
    @FXML
    private ComboBox<String> standEnFeria;
    @FXML
    private TextField descripcionAus;
    @FXML
    private Button asignaR;
    @FXML
    private Button cancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Feria> fer = MenuFeria.ferias;
        ObservableList<String> items1 = FXCollections.observableArrayList();
        
        for(Feria feria:fer){
         items1.add(feria.getNombre());
         }
        ObservableList<String> items2 = FXCollections.observableArrayList("si","no");
        standEnFeria.setItems(items2);
        ferias_box.setItems(items1);
    }    

    @FXML
    private void asignar(ActionEvent event) {
        
        
        
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        App.setRoot("menuAuspiciante");
    }
    
}
