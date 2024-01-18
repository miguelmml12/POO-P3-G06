/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit thisc template
 */
package com.mycompany.proyectopoo;
import modelo.*;
import interfaces.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 * 
 */

public class PrimaryController implements Initializable {

    @FXML
    private VBox table;
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Feria> fer = MenuFeria.ferias;

        for(Feria feria:fer){
            HBox caja = new HBox();
            HBox cod = new HBox();
            cod.setPrefWidth(52);
            cod.setPrefHeight(90);
            cod.setAlignment(Pos.CENTER);
            cod.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label codigo = new Label(String.valueOf(feria.getCodigo()));
            cod.getChildren().add(codigo);
            
            HBox name = new HBox();
            name.setPrefWidth(100);
            name.setPrefHeight(90);
            name.setAlignment(Pos.CENTER);
            name.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label nombre = new Label(feria.getNombre());
            name.getChildren().add(nombre);
            
            HBox fecha = new HBox();
            fecha.setPrefWidth(100);
            fecha.setPrefHeight(90);
            fecha.setAlignment(Pos.CENTER);
            fecha.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label date = new Label(feria.getFechaInicio());
            fecha.getChildren().add(date);
            
            HBox lugar = new HBox();
            lugar.setPrefWidth(100);
            lugar.setPrefHeight(90);
            lugar.setAlignment(Pos.CENTER);
            lugar.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label place = new Label(feria.getLugar());
            lugar.getChildren().add(place);
            
            HBox noAus = new HBox();
            noAus.setPrefWidth(100);
            noAus.setPrefHeight(90);
            noAus.setAlignment(Pos.CENTER);
            noAus.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label ausNo = new Label(String.valueOf(feria.getAuspiciantes_en_feria().size()));
            noAus.getChildren().add(ausNo);
            
            HBox noEmp = new HBox();
            noEmp.setPrefWidth(100);
            noEmp.setPrefHeight(90);
            noEmp.setAlignment(Pos.CENTER);
            noEmp.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            Label nOEmp = new Label(String.valueOf(feria.getEmprendedores().size()));
            noEmp.getChildren().add(nOEmp);
            
            HBox opc = new HBox();
            opc.setStyle("-fx-border-color: black; -fx-border-width: 1px;"); 
            opc.setPrefWidth(148);
            opc.setPrefHeight(90);
            VBox op = new VBox();
            Hyperlink details = new Hyperlink("Detalles");
            Hyperlink viewEmp = new Hyperlink("Ver Emprendedores");
            Hyperlink viewAus = new Hyperlink("\"Ver Auspiciante\"");
            Hyperlink viewStands = new Hyperlink("Ver Stands");
            op.getChildren().addAll(details,viewEmp,viewAus,viewStands);
            opc.getChildren().add(op);
            
            caja.getChildren().addAll(cod,name,fecha, lugar, noAus, noEmp,opc);
            table.getChildren().add(caja);
            
 
            
            
        }
    

    }  
        private void abrirEmp(ActionEvent event) {
    }

    @FXML
    private void detalles(ActionEvent event) {
    }

    @FXML
    private void nuevafer(ActionEvent event) throws IOException {
        App.setRoot("menuFerias");
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void verEmp(ActionEvent event) {
    }

    @FXML
    private void verAus(ActionEvent event) {
    }

    @FXML
    private void verStands(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }
    
}
