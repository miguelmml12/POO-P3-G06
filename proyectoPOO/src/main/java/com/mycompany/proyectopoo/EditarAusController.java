package com.mycompany.proyectopoo;

import interfaces.AuspicianteManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Auspiciante;
import modelo.Sector;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EditarAusController implements Initializable {

    @FXML
    private Button botonGuardar;
    @FXML
    private Button cancelarBoton;
    @FXML
    private TextField nombreEditAus;
    @FXML
    private TextField telefonoEditAus;
    @FXML
    private TextField emailEditAus;
    @FXML
    private TextField direccionEditAus;
    @FXML
    private TextField websiteEditAus;
    @FXML
    private TextField personaResEditAus;
    @FXML
    private TextField secEditAus;
    private Auspiciante auspicianteActual;
    @FXML
    private ComboBox<String> CmBoxEditarAus;

    private void onCmBoxEditarAusChanged(ActionEvent event) {
        // Llama al método para obtener el auspiciante seleccionado
        obtenerAuspiciantePorCedula();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Auspiciante> auspicianteS = AuspicianteManager.auspiciantes;
        ObservableList<String> items1 = FXCollections.observableArrayList();

        for (Auspiciante aus : auspicianteS) {
            items1.add(aus.getCedula());
        }

        CmBoxEditarAus.setItems(items1);
        CmBoxEditarAus.setOnAction(this::onCmBoxEditarAusChanged);
    }

    private void cargarDatosAuspicianteSeleccionado() {
        String cedulaSeleccionada = CmBoxEditarAus.getValue();

        // Obtener el auspiciante correspondiente a la cédula seleccionada
        Auspiciante auspicianteSeleccionado = AuspicianteManager.buscarAuspiciantePorID(cedulaSeleccionada);

        // Rellenar los campos con la información del auspiciante seleccionado
        nombreEditAus.setText(auspicianteSeleccionado.getNombre());
        telefonoEditAus.setText(auspicianteSeleccionado.getTelefono());
        emailEditAus.setText(auspicianteSeleccionado.getEmail());
        direccionEditAus.setText(auspicianteSeleccionado.getDireccion());
        websiteEditAus.setText(auspicianteSeleccionado.getSitioWeb());
        personaResEditAus.setText(auspicianteSeleccionado.getNombrePersona());
        secEditAus.setText(String.valueOf(auspicianteSeleccionado.getSector().ordinal()));
    }

    private void obtenerAuspiciantePorCedula() {
        // Obtén la cédula seleccionada del ComboBox
        String cedulaSeleccionada = CmBoxEditarAus.getSelectionModel().getSelectedItem();

        // Verifica que se haya seleccionado una cédula
        if (cedulaSeleccionada != null) {
            // Utiliza AuspicianteManager para obtener el auspiciante por cédula
            Auspiciante auspiciante = AuspicianteManager.buscarAuspiciantePorID(cedulaSeleccionada);

            // Verifica que el auspiciante no sea nulo
            if (auspiciante != null) {
                // Llena los campos con la información del auspiciante
                setCamposAuspicianteActual(auspiciante);
            } else {
                // Muestra un mensaje de error si no se encuentra el auspiciante
                System.out.println("Error: Auspiciante no encontrado");
            }
        } else {
            // Muestra un mensaje si no se ha seleccionado ninguna cédula
            System.out.println("Por favor, selecciona una cédula");
        }
    }

    private void setCamposAuspicianteActual(Auspiciante auspiciante) {
        this.auspicianteActual = auspiciante;
        // Rellenar los campos con la información del auspiciante actual
        nombreEditAus.setText(auspiciante.getNombre());
        telefonoEditAus.setText(auspiciante.getTelefono());
        emailEditAus.setText(auspiciante.getEmail());
        direccionEditAus.setText(auspiciante.getDireccion());
        websiteEditAus.setText(auspiciante.getSitioWeb());
        personaResEditAus.setText(auspiciante.getNombrePersona());
        secEditAus.setText(String.valueOf(auspiciante.getSector().ordinal()));
    }

    @FXML
    private void guardarCambiosAus(ActionEvent event) throws IOException {
    // Actualizar los datos del auspiciante actual con los valores de los campos
    auspicianteActual.setNombre(nombreEditAus.getText());
    auspicianteActual.setTelefono(telefonoEditAus.getText());
    auspicianteActual.setEmail(emailEditAus.getText());
    auspicianteActual.setDireccion(direccionEditAus.getText());
    auspicianteActual.setSitioWeb(websiteEditAus.getText());
    auspicianteActual.setNombrePersona(personaResEditAus.getText());

    try {
        int sectorIndex = Integer.parseInt(secEditAus.getText());
        // Verificar que el índice esté dentro de los límites del array de Sectores
        if (sectorIndex >= 0 && sectorIndex < Sector.values().length) {
            Sector sector = Sector.values()[sectorIndex];
            // Establecer el nuevo sector
            auspicianteActual.setSector(sector);
        } else {
            System.out.println("Error: Índice de sector fuera de rango");
        }
    } catch (NumberFormatException e) {
        System.out.println("Error: El valor del sector no es un número");
    }

    actualizarListaAuspiciantes();

    App.setRoot("menuAuspiciante");
}

private void actualizarListaAuspiciantes() {
    // Buscar y reemplazar el auspicianteActual en la lista de auspiciantes
    for (int i = 0; i < AuspicianteManager.auspiciantes.size(); i++) {
        Auspiciante auspiciante = AuspicianteManager.auspiciantes.get(i);
        if (auspiciante.getCedula().equals(auspicianteActual.getCedula())) {
            AuspicianteManager.auspiciantes.set(i, auspicianteActual);
            break; // Terminar el bucle 
        }
    }
}
    @FXML
    private void regresarMenuAus(ActionEvent event) throws IOException {
        App.setRoot("menuAuspiciante");
    }
}

