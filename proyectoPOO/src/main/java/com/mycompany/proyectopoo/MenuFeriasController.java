/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import com.mycompany.proyectopoo.App;
import interfaces.MenuFeria;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Feria;
import modelo.Stand;
/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class MenuFeriasController implements Initializable {


    @FXML
    private Button guardarBoton;
    @FXML
    private Button cancelarBoton;
    @FXML
    private TextField name;
    @FXML
    private TextField description;
    @FXML
    private TextField place;
    @FXML
    private TextField f_i;
    @FXML
    private TextField f_f;
    @FXML
    private TextField time;
    @FXML
    private TextField s_1;
    @FXML
    private TextField s_2;
    @FXML
    private TextField s_3;
    @FXML
    private TextField s_4;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void guardar(ActionEvent event) throws IOException {
        
        String nombre = name.getText();
        String descripcion = description.getText();
        String lugar = place.getText();
        String fechaInicio = f_i.getText();
        String fechaFin = f_f.getText();
        String horario = time.getText();
        
        
        ArrayList<Stand> seccion1 = new ArrayList<Stand>();
        ArrayList<Stand> seccion2 = new ArrayList<Stand>();
        ArrayList<Stand> seccion3 = new ArrayList<Stand>();
        ArrayList<Stand> seccion4 = new ArrayList<Stand>();
        
        int b = 1;
        int cantidadStands = Integer.parseInt(s_1.getText());
            for (int i = 0; i < cantidadStands; i++) {
                seccion1.add(new Stand("A" + b));
              b++;
            }
            b = 0; //reseteo contador
            cantidadStands = Integer.parseInt(s_2.getText());

            for (int i = 0; i < cantidadStands; i++) {
              b++;
                seccion2.add(new Stand("B"+ b));
            }
          b = 0;
          cantidadStands = Integer.parseInt(s_3.getText());


            for (int i = 0; i < cantidadStands; i++) {
              b++;
                seccion3.add(new Stand("C"+ b));
            }
          b = 0;
          cantidadStands = Integer.parseInt(s_4.getText());

            for (int i = 0; i < cantidadStands; i++) {
              b++;
                seccion4.add(new Stand("D"+ b));
            }

            Feria nuevaFeria = new Feria(nombre, descripcion, lugar, fechaInicio, fechaFin, horario, seccion1, seccion2, seccion3, seccion4);
            MenuFeria.ferias.add(nuevaFeria);
            App.setRoot("menuPrincipal");
        
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
