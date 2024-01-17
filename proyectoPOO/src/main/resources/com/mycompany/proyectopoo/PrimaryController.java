/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;
import modelo.*;
import interfaces.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 * 
 */

public class PrimaryController implements Initializable {

    private TableView<ArrayList<Feria>> table;
    private TableColumn<ArrayList<Feria>,String> cod;
    private TableColumn<ArrayList<Feria>,String> name;
    private TableColumn<ArrayList<Feria>,String> f_inicio;
    private TableColumn<ArrayList<Feria>,String> place;
    private TableColumn<ArrayList<Feria>,Integer> n_aus;
    private TableColumn<ArrayList<Feria>,Integer> n_emp;

    
    ObservableList<ArrayList<Feria>> ferias = table.getItems();
    ArrayList<Feria> fer = MenuFeria.ferias;

     /* Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cod.setCellValueFactory(new PropertyValueFactory);
         ferias.add(fer);
    }    
    
}
