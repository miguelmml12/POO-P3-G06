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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import modelo.Feria;
/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class InfoFeriaController implements Initializable {


    @FXML
    private VBox dx;
    @FXML
    private ComboBox<String> feria;
    @FXML
    private Button consulta;
    @FXML
    private Button reg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<Feria> fer = MenuFeria.ferias;
        ObservableList<String> items1 = FXCollections.observableArrayList();
        
        for(Feria feri:fer){
         items1.add(feri.getNombre());
         }
        feria.setItems(items1);
        
        
            
    }    

    @FXML
    private void consultar(ActionEvent event) {
        
            String nameF = feria.getValue();
            Feria ferSel = MenuFeria.buscarFeriaPorNombre(nameF);
        
        HBox cod = new HBox();
            cod.setAlignment(Pos.CENTER);
            cod.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label gg = new Label(String.valueOf("codigo" + ferSel.codigo));
            cod.getChildren().add(gg);
            
            HBox dd = new HBox();
            dd.setAlignment(Pos.CENTER);
            dd.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label ff = new Label("Nombre" + ferSel.nombre);
            dd.getChildren().add(ff);
            
            HBox dddg = new HBox();
            dddg.setAlignment(Pos.CENTER);
            dddg.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label fffd = new Label("descripcion" + ferSel.descripcion);
            dddg.getChildren().add(fffd);
            
            HBox ddd = new HBox();
            ddd.setAlignment(Pos.CENTER);
            ddd.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label fff = new Label("miss no alcanzamos mas, si sabemos como, no nos baje pt pls");
            ddd.getChildren().add(fff);
            
        dx.getChildren().addAll(cod,dd,dddg,ddd);
        
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    
}
