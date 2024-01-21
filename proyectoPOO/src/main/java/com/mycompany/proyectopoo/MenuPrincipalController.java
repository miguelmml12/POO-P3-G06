/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this tempalate
 */
package com.mycompany.proyectopoo;

import com.mycompany.proyectopoo.App;
import interfaces.AuspicianteManager;
import interfaces.MenuEmprendedor;
import interfaces.MenuFeria;
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
 * @author Josue.jibaja
 */
public class MenuPrincipalController implements Initializable {


    @FXML
    private Button botonF;
    @FXML
    private Button botonS;
    @FXML
    private Button botonSalir;
    @FXML
    private Button botonEmp;
    @FXML
    private Button botonAus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Thread t = new Thread( () ->
        {

          MenuFeria.agregarFeriaTest();
          MenuEmprendedor.agregar4Emprendedores();
          AuspicianteManager.agregarAspicianteInicial();   


     System.out.println(MenuFeria.ferias);

        });
        t.setDaemon(true);
        t.start();
    }    
    
    @FXML
    private void abrirFer(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }


    @FXML
    private void abrirStands(ActionEvent event) throws IOException {
        App.setRoot("menuStands");
    }

    @FXML
    private void salir(ActionEvent event) {
    }

    @FXML
    private void emp(ActionEvent event) throws IOException {
        App.setRoot("menuEmprendedor");
    }

    @FXML
    private void aus(ActionEvent event) throws IOException {
        App.setRoot("menuAuspiciante");
    }

}
