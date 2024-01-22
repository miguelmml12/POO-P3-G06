/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import com.mycompany.proyectopoo.App;
import interfaces.AuspicianteManager;
import interfaces.StandManager;
import static interfaces.StandManager.buscarStandPorCodigo;
import static interfaces.StandManager.fer;
import static interfaces.StandManager.menuStand;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Auspiciante;
import modelo.Stand;
/**
 * FXML Controller class
 *
 * @author Josue.jibaja
 */
public class AsignarStandController implements Initializable {


    @FXML
    private TextField stadCode;

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label message;
    @FXML
    private Button asignaR;
    @FXML
    private Button cancelaR;
    @FXML
    private TextField userCode;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> items = FXCollections.observableArrayList("emprendedor","auspiciante");
        comboBox.setItems(items);
    }    
    

    @FXML
    private void type(ActionEvent event) {
    }

    @FXML
    private void asignar(ActionEvent event) throws IOException {
        String cod = stadCode.getText();
      if (StandManager.buscarStandPorCodigo(cod) != null) {
          
          Stand stand = StandManager.buscarStandPorCodigo(cod);
          String standCod = stand.getCodigo();
          int len = standCod.length();

      if (len > 2) {
        message.setText("Stand no disponible");
      } else {
        String op = comboBox.getValue();
        if(op == "emprendedor"){
            //hola
        }
        if(op == "auspiciante"){
            message.setText("Sel Auspiciante");
            Auspiciante aus = null;
            String codAus = userCode.getText();
            aus = AuspicianteManager.buscarAuspiciantePorID(codAus);
            message.setText(aus.getNombre());
            int j = 0;
            int y = 0;
            if (aus != null) {
              
              if(MenuStandsController.fer.auspiciante_con_stand == null){
              
              if (MenuStandsController.fer.auspiciantes_en_feria != null){
              System.out.println(MenuStandsController.fer.auspiciantes_en_feria);
              for (Auspiciante Aus :  MenuStandsController.fer.auspiciantes_en_feria) {
                if (aus == Aus) {
                  j++;
                  stand.setCodigo(cod + "*");
               }

              }
              
              if(j == 1){
                MenuStandsController.fer.auspiciantes_en_feria.add(aus);
                MenuStandsController.fer.auspiciante_con_stand.add(aus);
                stand.setAuspiciante(aus);
                message.setText("Auspiciante asignado");
                
              }
              else{
                  message.setText("Auspiciante no asignado a Feria");
              }
            }
              else{
                  message.setText("Auspiciante no asignado a feria");
              }
           }
              else{
                  int i = 0;
                  for(Auspiciante aUs:MenuStandsController.fer.auspiciante_con_stand){
                      if (aus == aUs){
                          message.setText("Auspiciante con stand asignado");
                          i++;
                      }
                  }
                      if(i == 0){
                          if (MenuStandsController.fer.auspiciantes_en_feria != null){
              System.out.println(MenuStandsController.fer.auspiciantes_en_feria);
              for (Auspiciante Aus :  MenuStandsController.fer.auspiciantes_en_feria) {
                if (aus == Aus) {
                  j++;
                  stand.setCodigo(cod + "*");
               }

              }
              
              if(j == 1){
                MenuStandsController.fer.auspiciantes_en_feria.add(aus);
                MenuStandsController.fer.auspiciante_con_stand.add(aus);
                stand.setAuspiciante(aus);
                message.setText("Auspiciante asignado");
                
              }
              else{
                  message.setText("Auspiciante no asignado a Feria");
              }
            }
              else{
                  message.setText("Auspiciante no asignado a feria");
              }
                      }
                  }
                  
                  
              
        }
      }
     }

     }
    }
    
    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
