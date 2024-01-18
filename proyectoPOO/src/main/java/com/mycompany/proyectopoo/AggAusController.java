/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import interfaces.AuspicianteManager;
import static interfaces.AuspicianteManager.buscarAuspiciantePorID;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Auspiciante;
import modelo.Sector;
/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class AggAusController implements Initializable {


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
    @FXML
    public TextField sec;
    
       public  static String cedula;
       public static String name;
       public static String nombrePersona;
       public static String telefone;
       public static String mail;
       public static String direction;
       public static String sitioWeb;
       public static int num;
       public static Sector sector = Sector.ALIMENTACION;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void irRedes(ActionEvent event) throws IOException {
        
        cedula = idPerson.getText();
         name = nombre.getText();
         nombrePersona = personaRes.getText();
         telefone  = telefono.getText();
         mail = email.getText();
         direction = direccion.getText();
         sitioWeb = website.getText();
         num = Integer.parseInt(sec.getText());
         
         switch (num) {
            case 1:
                sector = Sector.ALIMENTACION;
                break;
            case 2:
                sector = Sector.EDUCACION;
                break;
            case 3:
                sector = Sector.SALUD;
                break;
            case 4:
                sector = Sector.VESTIMENTA;
                break;
        }
         App.setRoot("aggRedesAus");

    }
        

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
