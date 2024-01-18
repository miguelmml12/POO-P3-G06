/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;
import modelo.*;
import interfaces.*;
import interfaces.MenuFeria;
// import interfaces.MenuEmprendedor;
import java.util.Arrays;


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
    private Button botonE;
    @FXML
    private Button botonA;
    @FXML
    private Button botonS;
    @FXML
    private Button botonSalir;
    /**
     * Initializes the controller classf.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Thread t = new Thread( () ->
        {
             MenuFeria.agregarFeriaTest();
    MenuEmprendedor.agregar4Emprendedores();
    AuspicianteManager.agregarAspicianteInicial();
     System.out.println(MenuFeria.ferias);

        System.out.println("El codigo de la feria es el numero entero de la posicion en que fue creada (la feria ya creada (que se pide) tiene codigo 1)");
        });
        t.setDaemon(true);
        t.start();
   
    
    }    
    
    @FXML
    private void abrirFer(ActionEvent event)throws IOException {
//        Thread t = new Thread( () ->
//        {
//             MenuFeria.administracionDeFerias();
//
//        System.out.println("El codigo de la feria es el numero entero de la posicion en que fue creada (la feria ya creada (que se pide) tiene codigo 1)");
//        });
//        t.setDaemon(true);
//        t.start();
            App.setRoot("primary");

            
    }

        
    @FXML
    private void abrirEmp(ActionEvent event) {
    }

    @FXML
    private void abrirAus(ActionEvent event) {
    }

    @FXML
    private void abrirStands(ActionEvent event) {
    }

    @FXML
    private void salir(ActionEvent event) {
    }

}
