module com.mycompany.proyectopoo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyectopoo to javafx.fxml;
    exports com.mycompany.proyectopoo;
}
