/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import static interfaces.AuspicianteManager.auspiciantes;
import static interfaces.AuspicianteManager.buscarAuspiciantePorID;
import interfaces.MenuEmprendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Auspiciante;
import modelo.Emprendedor;
/**
 * FXML Controller class
 *
 * @author angel
 */
public class AggRedesEmpController implements Initializable {


    @FXML
    private Button botonSiguiente;
    @FXML
    private Button cancelarBoton;
    @FXML
    private TextField tw;
    @FXML
    private TextField fb;
    @FXML
    private TextField ig;
    @FXML
    private TextField yt;
    @FXML
    private TextField tikto;
    @FXML
    private TextField linkedl;
    @FXML
    private TextField pinteres;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    @FXML
    private void guardar(ActionEvent event) throws IOException {
        String twiter = tw.getText();
        String facebook = fb.getText();
        String instagram = ig.getText();
        String tiktok = tikto.getText();
        String linkedin = linkedl.getText();
        String pinterest = pinteres.getText();
        
        ArrayList<String> redesS = new ArrayList<String>();
        if (!twiter.isEmpty()) {
                    redesS.add(twiter);
                }
        if (!facebook.isEmpty()) {
                    redesS.add(facebook);
                }
        if (!instagram.isEmpty()) {
                    redesS.add(instagram);
                }
        if (!tiktok.isEmpty()) {
                    redesS.add(tiktok);
                }
        if (!linkedin.isEmpty()) {
                    redesS.add(linkedin);
                }
        if (!pinterest.isEmpty()) {
                    redesS.add(pinterest);
                }
        
        if (MenuEmprendedor.buscarEmprendedorPorID(AggEmpController.cedula) == null) {
            MenuEmprendedor.l_emprendedores.add(new Emprendedor(AggEmpController.cedula, AggEmpController.name, AggEmpController.nombrePersona, AggEmpController.telefone, AggEmpController.mail, AggEmpController.direction, AggEmpController.sitioWeb, redesS, AggEmpController.description));
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Emprendedor agregado");
            alert.setContentText("Volviendo al menu ☻");

            alert.showAndWait();
            
            App.setRoot("menuEmprendedor"); 
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Usuario ya existe");
            alert.setContentText("Ingrese otra ccedula");

            alert.showAndWait();


        }
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("menuEmprendedor");
    }

}
