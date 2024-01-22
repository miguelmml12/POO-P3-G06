/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo;

import interfaces.MenuEmprendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Emprendedor;
/**
 * FXML Controller class
 *
 * @author angel
 */
public class EditEmpController implements Initializable {



    @FXML
    private Button botonGuardarEmp;
    @FXML
    private TextField nombreEditEmp;
    @FXML
    private TextField telefonoEditEmp;
    @FXML
    private TextField emailEditEmp;
    @FXML
    private TextField direccionEditEmp;
    @FXML
    private TextField websiteEditEmp;
    @FXML
    private TextField personaResEditEmp;
    @FXML
    private TextField secEditEmp;
    @FXML
    private ComboBox<String> CmBoxEditarEmp;
    private Emprendedor emprendedorActual;
    
    @FXML
    private Button botonRedes;
    @FXML
    private Button cancelarBoton;
    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Emprendedor> emprendedores = MenuEmprendedor.getEmprendedores();
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Emprendedor emp : emprendedores) {
            items.add(emp.getCedula());
        }

        CmBoxEditarEmp.setItems(items);
        CmBoxEditarEmp.setOnAction(this::onCmBoxEditarEmpChanged);
    }

    private void onCmBoxEditarEmpChanged(ActionEvent event) {
        obtenerEmprendedorPorCedula();
    }

    private void obtenerEmprendedorPorCedula() {
        String cedulaSeleccionada = CmBoxEditarEmp.getSelectionModel().getSelectedItem();

        if (cedulaSeleccionada != null) {
            Emprendedor emprendedor = MenuEmprendedor.buscarEmprendedorPorID(cedulaSeleccionada);

            if (emprendedor != null) {
                setCamposEmprendedorActual(emprendedor);
            } else {
                System.out.println("Error: Emprendedor no encontrado");
            }
        } else {
            System.out.println("Por favor, selecciona una cédula");
        }
    }

    private void setCamposEmprendedorActual(Emprendedor emprendedor) {
        this.emprendedorActual = emprendedor;
        nombreEditEmp.setText(emprendedor.getNombre());
        telefonoEditEmp.setText(emprendedor.getTelefono());
        emailEditEmp.setText(emprendedor.getEmail());
        direccionEditEmp.setText(emprendedor.getDireccion());
        websiteEditEmp.setText(emprendedor.getSitioWeb());
        personaResEditEmp.setText(emprendedor.getNombrePersona());
    }

    @FXML
    private void guardarCambiosEmp(ActionEvent event) throws IOException {
        emprendedorActual.setNombre(nombreEditEmp.getText());
        emprendedorActual.setTelefono(telefonoEditEmp.getText());
        emprendedorActual.setEmail(emailEditEmp.getText());
        emprendedorActual.setDireccion(direccionEditEmp.getText());
        emprendedorActual.setSitioWeb(websiteEditEmp.getText());
        emprendedorActual.setNombrePersona(personaResEditEmp.getText());

        actualizarListaEmprendedores();

        // Cambiar la vista a "menuEmprendedor" (ajusta el nombre según tu implementación)
        App.setRoot("menuEmprendedor");
    }

    private void actualizarListaEmprendedores() {
        ArrayList<Emprendedor> emprendedores = MenuEmprendedor.getEmprendedores();
        for (int i = 0; i < emprendedores.size(); i++) {
            Emprendedor emp = emprendedores.get(i);
            if (emp.getCedula().equals(emprendedorActual.getCedula())) {
                emprendedores.set(i, emprendedorActual);
                break;
            }
        }
    }

    @FXML
    private void regresarMenuEmp(ActionEvent event) throws IOException {
        // Cambiar la vista a "menuEmprendedor" (ajusta el nombre según tu implementación)
        App.setRoot("menuEmprendedor");
    }

    @FXML
    private void IrEditRedes(ActionEvent event) throws IOException {
        App.setRoot("editRedesEmp");
    }
}