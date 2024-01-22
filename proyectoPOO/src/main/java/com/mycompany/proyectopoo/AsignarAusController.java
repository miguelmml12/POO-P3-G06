/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import interfaces.AuspicianteManager;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Auspiciante;
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
    Feria feriaSel = null;
    Auspiciante ausSel = null;

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
        
        System.out.println(standEnFeria.getValue());
        System.out.println(id.getText());
        
        if(ferias_box.getValue() != null){
            if(!id.getText().isBlank()){
                if(standEnFeria.getValue() != null){
                    if(!descripcionAus.getText().isBlank()){
                        
                        feriaSel = MenuFeria.buscarFeriaPorNombre(ferias_box.getValue());
        String cedulaAus = id.getText();
        ausSel = AuspicianteManager.buscarAuspiciantePorID(cedulaAus);        
        feriaSel.auspiciantes_en_feria.add(ausSel);
        String op = standEnFeria.getValue();
        if(op == "si"){
            ausSel.stand_en_feria = true;
        }
        else{
            ausSel.stand_en_feria = false;
        }
       
        
                    }
                    else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Missing Error");
                        alert.setHeaderText("Missing description");
                        alert.setContentText("Please add a description of the sponsorship to be able to save it");
                        alert.showAndWait();

                    }
                }
                else{
                Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Missing Error");
                        alert.setHeaderText("Missing selection");
                        alert.setContentText("Please select yes/no in 'does it have a stand' to be able to save it");
                        alert.showAndWait();
                }
            }
            else{
            Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Missing Error");
                        alert.setHeaderText("Missing id");
                        alert.setContentText("Please add an ID of the sponsor to be able to save it");
                        alert.showAndWait();
            }
        }else{
        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Missing Error");
                        alert.setHeaderText("Missing fair");
                        alert.setContentText("Please a fair to be able to save it");
                        alert.showAndWait();
        }
        
        
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        App.setRoot("menuAuspiciante");
    }
    
}
